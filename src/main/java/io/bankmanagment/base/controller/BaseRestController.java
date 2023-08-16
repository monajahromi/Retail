package io.bankmanagment.base.controller;


import io.bankmanagment.base.exception.NotFoundException;
import io.bankmanagment.base.model.dto.BaseDto;
import io.bankmanagment.base.model.entity.BaseEntity;
import io.bankmanagment.base.service.IBaseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public class BaseRestController<E extends BaseEntity, RespDto extends BaseDto, ReqDto extends BaseDto>
        implements IBaseController<RespDto, ReqDto> {
    protected IBaseService<E, RespDto, ReqDto> baseService;

    public BaseRestController(IBaseService<E, RespDto, ReqDto> baseService) {
        this.baseService = baseService;
    }

    @Override
    @GetMapping("{id}")
    public ResponseEntity<RespDto> findBydId(@PathVariable(name = "id") Long id) throws NotFoundException {
        return new ResponseEntity<>(baseService.findById(id), HttpStatus.OK);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<RespDto>> findAll() {
        return new ResponseEntity<>(baseService.findAll(), HttpStatus.OK);
    }

    @Override
    @PostMapping
    public ResponseEntity<RespDto> create(@RequestBody @Valid ReqDto dto) {
        return new ResponseEntity<>(baseService.create(dto), HttpStatus.CREATED);
    }

    @Override
    @PutMapping
    public ResponseEntity<RespDto> update(@RequestBody @Valid ReqDto dto) throws NotFoundException {
        return new ResponseEntity<>(baseService.update(dto), HttpStatus.CREATED);
    }

    @Override
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable(name = "id") Long id) throws NotFoundException {
        baseService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
