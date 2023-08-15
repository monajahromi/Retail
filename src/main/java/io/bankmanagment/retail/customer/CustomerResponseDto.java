package io.bankmanagment.retail.customer;

import io.bankmanagment.base.model.dto.BaseDto;
import io.bankmanagment.retail.account.AccountResponseDto;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerResponseDto extends BaseDto {

    private String name;
    private String surname;
    private String code;
    private List<AccountResponseDto> accounts;
}
