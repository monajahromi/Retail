package io.bankmanagment.retail.transaction;

import io.bankmanagment.base.model.dto.BaseDto;
import io.bankmanagment.retail.account.AccountRequestDto;
import io.bankmanagment.retail.constants.TransactionOperationType;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionRequestDto extends BaseDto {

    private BigDecimal amount;
    private TransactionOperationType operationType;
    private AccountRequestDto account;
}
