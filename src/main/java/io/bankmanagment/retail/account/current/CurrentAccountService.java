package io.bankmanagment.retail.account.current;

import io.bankmanagment.base.exception.NotFoundException;
import io.bankmanagment.base.mapper.IBaseMapper;
import io.bankmanagment.base.repository.IBaseRepository;
import io.bankmanagment.retail.account.AccountService;
import io.bankmanagment.retail.config.CurrentAccountProperties;
import io.bankmanagment.retail.customer.CustomerDto;
import io.bankmanagment.retail.customer.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class CurrentAccountService extends AccountService<CurrentAccountEntity, CurrentAccountDto, CurrentAccountDto> {


    private final CurrentAccountProperties currentAccountProperties;
    private final CustomerService customerService;

    public CurrentAccountService(IBaseRepository<CurrentAccountEntity> baseRepository, IBaseMapper<CurrentAccountEntity, CurrentAccountDto, CurrentAccountDto> baseMapper, CurrentAccountProperties currentAccountProperties, CustomerService customerService) {
        super(baseRepository, baseMapper);
        this.currentAccountProperties = currentAccountProperties;
        this.customerService = customerService;
    }

    @Override
    public CurrentAccountDto create(CurrentAccountDto currentAccountDto) {
        CustomerDto customerDto;
        try {
            customerDto = customerService.findById(currentAccountDto.getCustomer().getId());
        } catch (NotFoundException e) {
            throw new RuntimeException("customer with this id not found!");
        }
        currentAccountDto.setCustomer(customerDto);
        currentAccountDto.setBalance(currentAccountProperties.getInitialBalance());
        currentAccountDto.setChequeBookAvailable(currentAccountProperties.getOpenWithChequeBook());

        return super.create(currentAccountDto);

    }

}
