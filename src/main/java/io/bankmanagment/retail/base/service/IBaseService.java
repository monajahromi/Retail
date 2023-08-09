package io.bankmanagment.retail.base.service;



import io.bankmanagment.retail.base.exception.NotFoundException;
import io.bankmanagment.retail.base.model.dto.BaseDto;
import io.bankmanagment.retail.base.model.entity.BaseEntity;

import java.util.List;

public interface IBaseService<T extends BaseEntity, GD extends BaseDto, PD extends BaseDto> {
    GD findById(Long id) throws NotFoundException;

    List<GD> findAll();

    GD create(PD dto);

    GD update(Long id, PD dto) throws NotFoundException;

    void deleteById(Long id);
}
