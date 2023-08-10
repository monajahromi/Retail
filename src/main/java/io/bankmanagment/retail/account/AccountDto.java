package io.bankmanagment.retail.account;

import io.bankmanagment.base.model.dto.BaseDto;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
public abstract class AccountDto extends BaseDto {

    @NotBlank
    private String number;
    private BigDecimal balance;

}