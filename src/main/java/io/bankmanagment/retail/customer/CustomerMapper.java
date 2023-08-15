package io.bankmanagment.retail.customer;

import io.bankmanagment.base.mapper.IBaseMapper;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring",builder = @Builder(disableBuilder = true))
public interface CustomerMapper extends IBaseMapper<CustomerEntity, CustomerDto, CustomerDto> {

}
