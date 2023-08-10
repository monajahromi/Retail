package io.bankmanagment.retail.account.current;

import io.bankmanagment.base.model.dto.BaseDto;
import io.bankmanagment.retail.account.AccountDto;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CurrentAccountDto extends AccountDto {

    private Boolean chequeBookAvailable;

}
