package io.bankmanagment.retail.transaction;

import io.bankmanagment.base.model.dto.BaseDto;
import io.bankmanagment.retail.account.AccountDto;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionDto extends BaseDto {

    @NotNull(message = "Amount cannot be blank")
    private BigDecimal amount;
    @NotNull(message = "Account cannot be null")
    private AccountDto account;
}
