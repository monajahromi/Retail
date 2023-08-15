package io.bankmanagment.base.mapper;


import io.bankmanagment.base.model.dto.BaseDto;
import io.bankmanagment.base.model.entity.BaseEntity;

public interface IBaseMapper<E extends BaseEntity, RespDto extends BaseDto, ReqDto extends BaseDto> {
    RespDto entityToRespDto(E entity);
    E reqDtoToEntity(ReqDto dto);
}
