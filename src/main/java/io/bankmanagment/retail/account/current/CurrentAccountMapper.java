package io.bankmanagment.retail.account.current;

import io.bankmanagment.retail.account.AccountMapper;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface CurrentAccountMapper extends AccountMapper<CurrentAccountEntity, CurrentAccountResponseDto, CurrentAccountRequestDto> {
    CurrentAccountRequestDto responseToRequest(CurrentAccountResponseDto responseDto);
}
