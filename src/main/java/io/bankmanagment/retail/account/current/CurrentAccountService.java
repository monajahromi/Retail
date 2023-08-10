package io.bankmanagment.retail.account.current;

import io.bankmanagment.base.exception.NotFoundException;
import io.bankmanagment.base.mapper.IBaseMapper;
import io.bankmanagment.base.repository.IBaseRepository;
import io.bankmanagment.retail.account.AccountService;
import io.bankmanagment.retail.config.CurrentAccountProperties;
import org.springframework.stereotype.Service;

@Service
public  class CurrentAccountService extends AccountService<CurrentAccountEntity,CurrentAccountDto,CurrentAccountDto> {


    private final CurrentAccountProperties currentAccountProperties;
    public CurrentAccountService(IBaseRepository<CurrentAccountEntity> baseRepository, IBaseMapper<CurrentAccountEntity, CurrentAccountDto, CurrentAccountDto> baseMapper, CurrentAccountProperties currentAccountProperties) {
        super(baseRepository, baseMapper);
        this.currentAccountProperties = currentAccountProperties;
    }

    @Override
    public CurrentAccountDto create(CurrentAccountDto dto) {
        dto.setBalance(currentAccountProperties.getInitialBalance());
        dto.setChequeBookAvailable(currentAccountProperties.getOpenWithChequeBook());

        return super.create(dto);

    }

}
