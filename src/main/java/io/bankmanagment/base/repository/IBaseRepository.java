package io.bankmanagment.base.repository;


import io.bankmanagment.base.model.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface IBaseRepository<E extends BaseEntity> extends JpaRepository<E, Long> {

    Optional<List<E>> findByDeleted(Boolean deleted) ;

}
