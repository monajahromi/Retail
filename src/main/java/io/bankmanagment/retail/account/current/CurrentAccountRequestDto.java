package io.bankmanagment.retail.account.current;

import io.bankmanagment.retail.account.AccountRequestDto;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CurrentAccountRequestDto extends AccountRequestDto {

    private Long customerID;
    private BigDecimal initialCredit;
    private Boolean chequeBookAvailable;

}
