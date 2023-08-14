package io.bankmanagment.retail.transaction;


import io.bankmanagment.base.model.entity.BaseEntity;
import io.bankmanagment.retail.account.AccountEntity;
import io.bankmanagment.retail.constants.TransactionOperationType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@EntityListeners(AuditingEntityListener.class)
@Table(name = "transaction")
public class TransactionEntity extends BaseEntity {

    @NotNull(message = "Amount cannot be null")
    private BigDecimal amount;

    @ManyToOne
    @NotNull(message = "Account cannot be null")
    private AccountEntity account;

    @NotNull(message = "Operation type cannot be null")
    @Enumerated(EnumType.STRING)
    private TransactionOperationType operationType;

}
