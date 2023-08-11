package io.bankmanagment.retail.account;

import io.bankmanagment.base.model.dto.BaseDto;
import io.bankmanagment.retail.customer.CustomerDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
public class AccountDto extends BaseDto {

    @NotBlank(message = "Number cannot be blank")
    private String number;
    private BigDecimal balance;
    @NotNull(message = "Customer cannot be blank")
    private CustomerDto customer;

}
