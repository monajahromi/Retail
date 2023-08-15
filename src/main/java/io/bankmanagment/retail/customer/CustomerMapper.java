package io.bankmanagment.retail.customer;

import io.bankmanagment.base.mapper.IBaseMapper;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring",builder = @Builder(disableBuilder = true))
public interface CustomerMapper extends IBaseMapper<CustomerEntity, CustomerDto, CustomerDto> {
//
//    CustomerDto entityToGetDto(CustomerEntity entity);
//
//    CustomerEntity postDtoToEntity(CustomerDto dto);
//
//
////    default CustomerDto entityToGetDtoWithAccounts(CustomerEntity entity) {
////        CustomerDto entity = postDtoToEntity(dto);
////        if (dto.getAccounts() != null) {
////            entity.setAccounts(
////                    dto.getAccounts().stream()
////                            .map(accountDto -> toAccountEntity(accountDto, entity))
////                            .collect(Collectors.toList())
////            );
////        }
////        return entity;
////    }
}
