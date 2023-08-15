package io.bankmanagment.retail.account.current;

import io.bankmanagment.base.exception.NotFoundException;
import io.bankmanagment.base.mapper.IBaseMapper;
import io.bankmanagment.base.repository.IBaseRepository;
import io.bankmanagment.retail.account.AccountService;
import io.bankmanagment.retail.config.CurrentAccountProperties;
import io.bankmanagment.retail.constants.TransactionOperationType;
import io.bankmanagment.retail.customer.CustomerEntity;
import io.bankmanagment.retail.customer.CustomerRepository;
import io.bankmanagment.retail.transaction.TransactionEntity;
import io.bankmanagment.retail.transaction.TransactionRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CurrentAccountService extends AccountService<CurrentAccountEntity, CurrentAccountResponseDto, CurrentAccountRequestDto> {


    private final CurrentAccountProperties currentAccountProperties;
    private final CustomerRepository customerRepository;
    private final TransactionRepository transactionRepository;

    public CurrentAccountService(IBaseRepository<CurrentAccountEntity> baseRepository, IBaseMapper<CurrentAccountEntity, CurrentAccountResponseDto, CurrentAccountRequestDto> baseMapper, CurrentAccountProperties currentAccountProperties, CustomerRepository customerRepository, TransactionRepository transactionRepository) {
        super(baseRepository, baseMapper);
        this.currentAccountProperties = currentAccountProperties;
        this.customerRepository = customerRepository;
        this.transactionRepository = transactionRepository;

    }


    public CurrentAccountResponseDto createWithInitialCredit(CurrentAccountRequestDto requestDto) throws NotFoundException {
       CustomerEntity customerEntity = customerRepository
                     .findById(requestDto.getCustomerID()).orElseThrow(NotFoundException::new);


        CurrentAccountEntity entity = new CurrentAccountEntity();
        entity.setCustomer(customerEntity);
        entity.setNumber(accountNumberGenerator(customerEntity.getCode()));
        entity.setBalance(currentAccountProperties.getInitialBalance());
        entity.setBalanceFloor(currentAccountProperties.getInitialBalanceFloor());
        entity.setChequeBookAvailable(currentAccountProperties.getOpenWithChequeBook());
        CurrentAccountEntity created = baseRepository.save(entity);
        try {
            deposit(created, requestDto.getInitialCredit());
        } catch (NotFoundException e) {
            e.printStackTrace();
        }


        return baseMapper.entityToRespDto(created);

    }

    public CurrentAccountEntity deposit(CurrentAccountEntity currentAccountEntity, BigDecimal amount) throws NotFoundException {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Amount cannot be negative for deposit");
        }

        currentAccountEntity.setBalance(currentAccountEntity.getBalance().add(amount));
        CurrentAccountEntity updated = baseRepository.save(currentAccountEntity);
        TransactionEntity transactionEntity = TransactionEntity.builder()
                .account(updated)
                .amount(amount)
                .operationType(TransactionOperationType.DEPOSIT)
                .build();

        transactionRepository.save(transactionEntity);
        return updated;
    }


    public CurrentAccountEntity withdraw(CurrentAccountEntity currentAccountEntity, BigDecimal amount) throws NotFoundException {

        BigDecimal newBalance = currentAccountEntity.getBalance().subtract(amount);
        if (newBalance.compareTo(currentAccountEntity.getBalanceFloor()) < 0) {
            throw new RuntimeException("Insufficient balance for withdrawal");
        }
        currentAccountEntity.setBalance(newBalance);
        CurrentAccountEntity updated = baseRepository.save(currentAccountEntity);


        TransactionEntity transactionEntity = TransactionEntity.builder()
                .account(updated)
                .amount(amount)
                .operationType(TransactionOperationType.WITHDRAWAL)
                .build();

        transactionRepository.save(transactionEntity);
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
