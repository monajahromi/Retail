package io.bankmanagment.retail.base.mapper;


import io.bankmanagment.retail.base.model.dto.BaseDto;
import io.bankmanagment.retail.base.model.entity.BaseEntity;

public interface IBaseMapper<T extends BaseEntity, GD extends BaseDto, PD extends BaseDto> {
    GD entityToGetDto(T entity);
    T postDtoToEntity(PD dto);
}
