package io.bankmanagment.retail.account;


import io.bankmanagment.base.model.entity.BaseEntity;
import io.bankmanagment.retail.customer.CustomerEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="account")
public abstract class AccountEntity extends BaseEntity {

    @NotBlank(message = "Number cannot be blank")
    @Column(unique = true)
    private String number;
    @NotNull(message = "Balance cannot be null")
    private BigDecimal balance;
    @ManyToOne
    @NotNull(message = "Customer cannot be null")
    private CustomerEntity customer;

}
