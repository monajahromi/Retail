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
public class CustomerService extends BaseService<CustomerEntity, CustomerDto, CustomerDto> {

    private final CustomerRepository customerRepository;
    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public CustomerService(IBaseRepository<CustomerEntity> baseRepository, IBaseMapper<CustomerEntity, CustomerDto, CustomerDto> baseMapper, CustomerRepository customerRepository, AccountRepository accountRepository, TransactionRepository transactionRepository) {
        super(baseRepository, baseMapper);
        this.customerRepository = customerRepository;
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }


    @Override
    public List<CustomerDto> findAll() {
        List<CustomerEntity> cs = baseRepository.findAll();
        System.out.println("cs-------------------: " + cs);
        return cs.stream().map(baseMapper::entityToGetDto).collect(Collectors.toList());
        //return super.findAll();
    }

    public CustomerDto getDetailsById(Long id) throws NotFoundException {
        CustomerEntity customerEntity  = baseRepository.findById(id).orElseThrow(NotFoundException::new);


        List<AccountEntity> accountEntities = accountRepository.findByCustomer(customerEntity) ;

        List<AccountEntity> accountWithTransactions=  accountEntities
                .stream().map((item)->{
              item.setTransactions(transactionRepository.findByAccount(item));
              return item;

        }).collect(Collectors.toList());

//        System.out.println("customerEntity: " + customerEntity);
//        List<AccountEntity> accountEntities = customerEntity.getAccounts().stream().map(item ->
//                accountRepository.findByIdWithTransactions(item.getId())
//        ).collect(Collectors.toList());

        customerEntity.setAccounts(accountWithTransactions);
        CustomerDto customerDto = baseMapper.entityToGetDto(customerEntity);


        return customerDto;
    }
}
