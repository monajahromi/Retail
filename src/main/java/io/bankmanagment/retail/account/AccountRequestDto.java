package io.bankmanagment.retail.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.bankmanagment.base.model.dto.BaseDto;
import io.bankmanagment.retail.customer.CustomerRequestDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
public class AccountRequestDto extends BaseDto {

    @JsonIgnore
    private String number;
    @JsonIgnore
    private BigDecimal balance;
    @JsonIgnore
    private BigDecimal balanceFloor;
    @JsonIgnore
    private CustomerRequestDto customer;

}
