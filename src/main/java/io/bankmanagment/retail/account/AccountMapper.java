package io.bankmanagment.retail.account;

import io.bankmanagment.base.mapper.IBaseMapper;
import io.bankmanagment.retail.customer.CustomerDto;
import io.bankmanagment.retail.customer.CustomerEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

public interface AccountMapper<A extends AccountEntity, B extends AccountDto, C extends AccountDto>
        extends IBaseMapper<A, B, C> {
}
