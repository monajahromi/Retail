package io.bankmanagment.retail.customer;

import io.bankmanagment.base.model.dto.BaseDto;
import io.bankmanagment.retail.account.AccountResponseDto;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerResponseDto extends BaseDto {

    @NotBlank(message = "Name cannot be blank")
    private String name;
    @NotBlank(message = "Surname cannot be blank")
    private String surname;
    @NotBlank(message = "Code cannot be blank")
    private String code;
    private List<AccountResponseDto> accounts;
}
