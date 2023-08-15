package io.bankmanagment.retail.account.current;

import io.bankmanagment.retail.account.AccountResponseDto;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CurrentAccountResponseDto extends AccountResponseDto {
    private Boolean chequeBookAvailable;
}
