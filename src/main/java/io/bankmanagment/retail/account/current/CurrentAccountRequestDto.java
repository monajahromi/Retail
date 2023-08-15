package io.bankmanagment.retail.account.current;

import io.bankmanagment.retail.account.AccountDto;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CurrentAccountRequestDto extends AccountDto {

    private Long customerID;
    private BigDecimal initialCredit;

}
