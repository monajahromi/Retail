package io.bankmanagment.retail.account;

import io.bankmanagment.base.mapper.IBaseMapper;
import io.bankmanagment.base.repository.IBaseRepository;
import io.bankmanagment.base.service.BaseService;
import org.springframework.stereotype.Service;


public  class AccountService<A extends  AccountEntity, B extends AccountDto, C extends AccountDto> extends BaseService<A,B,C> {
    public AccountService(IBaseRepository<A> baseRepository, IBaseMapper<A, B, C> baseMapper) {
        super(baseRepository, baseMapper);
    }
}
