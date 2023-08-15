package io.bankmanagment.retail.account.current;

import lombok.*;

import java.math.BigDecimal;

@Data
public class CreateAccountRequestDto{

    private Long customerID;
    private BigDecimal initialCredit;

}
