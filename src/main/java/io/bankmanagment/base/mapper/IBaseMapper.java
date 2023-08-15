package io.bankmanagment.base.mapper;


import io.bankmanagment.base.model.dto.BaseDto;
import io.bankmanagment.base.model.entity.BaseEntity;

public interface IBaseMapper<T extends BaseEntity, RespDto extends BaseDto, ReqDto extends BaseDto> {
    RespDto entityToRespDto(T entity);
    T reqDtoToEntity(ReqDto dto);
}
