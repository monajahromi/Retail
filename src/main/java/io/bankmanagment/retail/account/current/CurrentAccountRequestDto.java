package io.bankmanagment.retail.account.current;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.bankmanagment.retail.account.AccountRequestDto;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CurrentAccountRequestDto extends AccountRequestDto {

    private Long customerID;
    private BigDecimal initialCredit;
    @JsonIgnore
    private Boolean chequeBookAvailable;

}
