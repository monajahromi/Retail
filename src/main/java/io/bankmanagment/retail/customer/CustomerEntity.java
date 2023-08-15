package io.bankmanagment.retail.customer;


import io.bankmanagment.base.model.entity.BaseEntity;
import io.bankmanagment.retail.account.AccountEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="customer")
public class CustomerEntity extends BaseEntity {

    @NotBlank(message = "Name cannot be blank")
    private String name;
    @NotBlank(message = "Surname cannot be blank")
    private String surname;
    @NotBlank(message = "Code cannot be blank")
    @Column(unique = true)
    private String code;
    @OneToMany
    private List<AccountEntity> accounts;
}
