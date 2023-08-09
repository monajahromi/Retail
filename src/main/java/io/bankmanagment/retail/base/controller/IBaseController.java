package io.bankmanagment.retail.base.controller;


import io.bankmanagment.retail.base.exception.NotFoundException;
import io.bankmanagment.retail.base.model.dto.BaseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IBaseController<GD extends BaseDto, PD extends BaseDto> {
    ResponseEntity<GD> findBydId(Long id) throws NotFoundException;
    ResponseEntity<List<GD>> findAll();
    ResponseEntity<GD> create(PD dto);
    ResponseEntity<GD> update(PD dto) throws NotFoundException;
    ResponseEntity<Void> deleteById(Long id);
}
