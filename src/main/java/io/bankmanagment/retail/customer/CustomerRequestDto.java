package io.bankmanagment.retail.customer;

import io.bankmanagment.base.model.dto.BaseDto;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerRequestDto extends BaseDto {

    @NotBlank(message = "Name cannot be blank")
    private String name;
    @NotBlank(message = "Surname cannot be blank")
    private String surname;
    @NotBlank(message = "Code cannot be blank")
    private String code;

}
