package io.bankmanagment.retail.account;

import io.bankmanagment.base.model.dto.BaseDto;
import io.bankmanagment.retail.transaction.TransactionDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class AccountResponseDto extends BaseDto {

    private String number;
    private BigDecimal balance;
    private BigDecimal balanceFloor;
    private List<TransactionDto> transactions;

}
