package io.bankmanagment.retail.account;


import io.bankmanagment.base.model.entity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="account")
public abstract class AccountEntity extends BaseEntity {

    @NotBlank
    @Column(unique = true)
    private String number;
    @NotNull
    private BigDecimal balance;

}
