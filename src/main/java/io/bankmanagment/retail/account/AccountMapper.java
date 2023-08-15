package io.bankmanagment.retail.account;

import io.bankmanagment.base.mapper.IBaseMapper;

public interface AccountMapper<A extends AccountEntity, B extends AccountResponseDto, C extends AccountRequestDto>
        extends IBaseMapper<A, B, C> {
}
