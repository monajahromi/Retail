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

    @NotBlank(message = "Name can't be blank")
    private String name;
    @NotBlank(message = "Surname can't be blank")
    private String surname;
    @JsonIgnore
    private String code;



}
