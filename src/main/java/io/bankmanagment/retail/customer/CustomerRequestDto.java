package io.bankmanagment.retail.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private String code;

}
