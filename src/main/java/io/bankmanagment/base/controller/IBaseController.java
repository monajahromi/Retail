package io.bankmanagment.base.controller;


import io.bankmanagment.base.exception.NotFoundException;
import io.bankmanagment.base.model.dto.BaseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IBaseController<RespDto extends BaseDto, ReqDto extends BaseDto> {
    ResponseEntity<RespDto> findBydId(Long id) throws NotFoundException;
    ResponseEntity<List<RespDto>> findAll();
    ResponseEntity<RespDto> create(ReqDto dto);
    ResponseEntity<RespDto> update(ReqDto dto) throws NotFoundException;
    ResponseEntity<Void> deleteById(Long id) throws NotFoundException;
}
