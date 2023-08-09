package io.bankmanagment.base.mapper;


import io.bankmanagment.base.model.dto.BaseDto;
import io.bankmanagment.base.model.entity.BaseEntity;

public interface IBaseMapper<T extends BaseEntity, GD extends BaseDto, PD extends BaseDto> {
    GD entityToGetDto(T entity);
    T postDtoToEntity(PD dto);
}
