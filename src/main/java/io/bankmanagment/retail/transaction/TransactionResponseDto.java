package io.bankmanagment.retail.transaction;

import io.bankmanagment.base.model.dto.BaseDto;
import io.bankmanagment.retail.constants.TransactionOperationType;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionResponseDto extends BaseDto {

    private BigDecimal amount;
    private TransactionOperationType operationType;
}
