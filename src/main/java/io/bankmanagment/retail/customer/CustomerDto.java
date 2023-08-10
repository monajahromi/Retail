package io.bankmanagment.retail.customer;

import io.bankmanagment.base.model.dto.BaseDto;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDto extends BaseDto {

    @NotBlank
    private String name;
    @NotBlank
    private String surname;
}
