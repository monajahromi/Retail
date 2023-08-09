package io.bankmanagment.base.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected Date created_at;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected Date updated_at;
    protected Boolean deleted = false;
}
