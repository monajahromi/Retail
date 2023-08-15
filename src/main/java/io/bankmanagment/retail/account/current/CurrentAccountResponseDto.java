package io.bankmanagment.retail.account.current;

import io.bankmanagment.retail.account.AccountDto;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CurrentAccountResponseDto extends AccountDto {
    private Boolean chequeBookAvailable;
}