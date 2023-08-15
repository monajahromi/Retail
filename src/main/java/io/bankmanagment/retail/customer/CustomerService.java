package io.bankmanagment.retail.customer;

import io.bankmanagment.base.exception.NotFoundException;
import io.bankmanagment.base.mapper.IBaseMapper;
import io.bankmanagment.base.repository.IBaseRepository;
import io.bankmanagment.base.service.BaseService;
import io.bankmanagment.retail.account.AccountEntity;
import io.bankmanagment.retail.account.AccountRepository;
import io.bankmanagment.retail.transaction.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService extends BaseService<CustomerEntity, CustomerResponseDto, CustomerRequestDto> {

    private final CustomerRepository customerRepository;
    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public CustomerService(IBaseRepository<CustomerEntity> baseRepository, IBaseMapper<CustomerEntity, CustomerResponseDto, CustomerRequestDto> baseMapper, CustomerRepository customerRepository, AccountRepository accountRepository, TransactionRepository transactionRepository) {
        super(baseRepository, baseMapper);
        this.customerRepository = customerRepository;
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }


    public CustomerResponseDto getDetailsById(Long id) throws NotFoundException {
        CustomerEntity customerEntity  = baseRepository.findById(id).orElseThrow(NotFoundException::new);


        List<AccountEntity> accountEntities = accountRepository.findByCustomer(customerEntity) ;

        List<AccountEntity> accountWithTransactions=  accountEntities
                .stream().map((item)->{
              item.setTransactions(transactionRepository.findByAccount(item));
              return item;

        }).collect(Collectors.toList());

        customerEntity.setAccounts(accountWithTransactions);
        CustomerResponseDto customerDto = baseMapper.entityToRespDto(customerEntity);


        return customerDto;
    }
}
