package io.bankmanagment.retail.account.current;

import io.bankmanagment.retail.account.AccountEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@EntityListeners(AuditingEntityListener.class)
@Table(name="current_account")
@ToString(callSuper = true)
public class CurrentAccountEntity extends AccountEntity {

    private Boolean chequeBookAvailable;
}
