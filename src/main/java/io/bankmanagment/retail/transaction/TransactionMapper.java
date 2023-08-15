package io.bankmanagment.retail.transaction;

import io.bankmanagment.base.mapper.IBaseMapper;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface TransactionMapper extends IBaseMapper<TransactionEntity, TransactionResponseDto, TransactionRequestDto> {
}
