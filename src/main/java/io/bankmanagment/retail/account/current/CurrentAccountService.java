package io.bankmanagment.retail.account.current;

import io.bankmanagment.base.exception.NotFoundException;
import io.bankmanagment.base.mapper.IBaseMapper;
import io.bankmanagment.base.repository.IBaseRepository;
import io.bankmanagment.retail.account.AccountService;
import io.bankmanagment.retail.config.CurrentAccountProperties;
import io.bankmanagment.retail.constants.TransactionOperationType;
import io.bankmanagment.retail.customer.CustomerRequestDto;
import io.bankmanagment.retail.customer.CustomerResponseDto;
import io.bankmanagment.retail.customer.CustomerService;
import io.bankmanagment.retail.transaction.TransactionRepository;
import io.bankmanagment.retail.transaction.TransactionRequestDto;
import io.bankmanagment.retail.transaction.TransactionService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Transactional
public class CurrentAccountService extends AccountService<CurrentAccountEntity, CurrentAccountResponseDto, CurrentAccountRequestDto> {


    private final CurrentAccountProperties currentAccountProperties;
    private final TransactionRepository transactionRepository;
    private final CustomerService customerService;
    private final TransactionService transactionService;
    private final CurrentAccountMapper currentAccountMapper;

    public CurrentAccountService(IBaseRepository<CurrentAccountEntity> baseRepository, IBaseMapper<CurrentAccountEntity, CurrentAccountResponseDto, CurrentAccountRequestDto> baseMapper, CurrentAccountProperties currentAccountProperties, TransactionRepository transactionRepository, CustomerService customerService, TransactionService transactionService, CurrentAccountMapper currentAccountMapper) {
        super(baseRepository, baseMapper);
        this.currentAccountProperties = currentAccountProperties;
        this.transactionRepository = transactionRepository;
        this.customerService = customerService;
        this.transactionService = transactionService;
        this.currentAccountMapper = currentAccountMapper;
    }

    @Override
    public CurrentAccountResponseDto create(CurrentAccountRequestDto currentAccountRequestDto) {
        CustomerResponseDto customer = null;
        try {
            customer = customerService.findById(currentAccountRequestDto.getCustomerID());
        } catch (NotFoundException e) {
            RuntimeException runtimeException = new RuntimeException();
            runtimeException.initCause(e);
            throw runtimeException;
        }
        CustomerRequestDto customerRequestDto = new CustomerRequestDto();
        customerRequestDto.setId(currentAccountRequestDto.getCustomerID());

        currentAccountRequestDto.setCustomer(customerRequestDto);
        currentAccountRequestDto.setNumber(accountNumberGenerator(customer.getCode()));
        currentAccountRequestDto.setBalance(currentAccountProperties.getInitialBalance());
        currentAccountRequestDto.setBalanceFloor(currentAccountProperties.getInitialBalanceFloor());
        currentAccountRequestDto.setChequeBookAvailable(currentAccountProperties.getOpenWithChequeBook());

        CurrentAccountResponseDto created = super.create(currentAccountRequestDto);
        return deposit(currentAccountMapper.responseToRequest(created), currentAccountRequestDto.getInitialCredit());

    }

    public CurrentAccountResponseDto deposit(CurrentAccountRequestDto currentAccountRequestDto, BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Amount cannot be negative for deposit");
        }

        currentAccountRequestDto.setBalance(currentAccountRequestDto.getBalance().add(amount));
        CurrentAccountResponseDto updated = null;
        try {
            updated = super.update(currentAccountRequestDto);
        } catch (NotFoundException e) {
            RuntimeException runtimeException = new RuntimeException();
            runtimeException.initCause(e);
            throw runtimeException;
        }
        TransactionRequestDto t = TransactionRequestDto.builder()
                .account(updated)
                .amount(amount)
                .operationType(TransactionOperationType.DEPOSIT)
                .build();

        transactionService.create(t);
        return updated;
    }


    public CurrentAccountResponseDto withdraw(CurrentAccountRequestDto currentAccountRequestDto, BigDecimal amount) {

        BigDecimal newBalance = currentAccountRequestDto.getBalance().subtract(amount);
        if (newBalance.compareTo(currentAccountRequestDto.getBalanceFloor()) < 0) {
            throw new IllegalArgumentException("Insufficient balance for withdrawal");
        }
        currentAccountRequestDto.setBalance(newBalance);
        CurrentAccountResponseDto updated = null;
        try {
            updated = super.update(currentAccountRequestDto);
        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        }
        TransactionRequestDto t = TransactionRequestDto.builder()
                .account(updated)
                .amount(amount)
                .operationType(TransactionOperationType.WITHDRAWAL)
                .build();

        transactionService.create(t);
        return updated;
    }

    private String accountNumberGenerator(String customerCode) {

        // Generating a random number between 1000 and 9999
        int randomNumber = (int) (Math.random() * (9999 - 1000 + 1) + 1000);

        String generatedAccountNumber = currentAccountProperties.getAccountNumber_Prefix() +
                currentAccountProperties.getAccountNumber_Separator() +
                customerCode +
                currentAccountProperties.getAccountNumber_Separator() +
                randomNumber;


        return generatedAccountNumber;

    }


}
