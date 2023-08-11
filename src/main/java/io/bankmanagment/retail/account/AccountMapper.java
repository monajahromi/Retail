package io.bankmanagment.retail.account;

import io.bankmanagment.base.mapper.IBaseMapper;

public interface AccountMapper<A extends AccountEntity, B extends AccountDto, C extends AccountDto>
        extends IBaseMapper<A, B, C> {
}
