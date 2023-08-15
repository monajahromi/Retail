package io.bankmanagment.base.service;


import io.bankmanagment.base.exception.NotFoundException;
import io.bankmanagment.base.model.dto.BaseDto;
import io.bankmanagment.base.model.entity.BaseEntity;

import java.util.List;

public interface IBaseService<T extends BaseEntity, RespDto extends BaseDto, ReqDto extends BaseDto> {
    RespDto findById(Long id) throws NotFoundException;

    List<RespDto> findAll();

    RespDto create(ReqDto dto);

    RespDto update(ReqDto dto) throws NotFoundException;

    void deleteById(Long id) throws NotFoundException;
}
