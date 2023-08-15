package io.bankmanagment.base.service;


import io.bankmanagment.base.exception.NotFoundException;
import io.bankmanagment.base.mapper.IBaseMapper;
import io.bankmanagment.base.model.dto.BaseDto;
import io.bankmanagment.base.model.entity.BaseEntity;
import io.bankmanagment.base.repository.IBaseRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BaseService<E extends BaseEntity, RespDto extends BaseDto, ReqDto extends BaseDto> implements IBaseService<E, RespDto, ReqDto> {
    protected IBaseRepository<E> baseRepository;
    protected IBaseMapper<E, RespDto, ReqDto> baseMapper;

    public BaseService(IBaseRepository<E> baseRepository, IBaseMapper<E, RespDto, ReqDto> baseMapper) {
        this.baseRepository = baseRepository;
        this.baseMapper = baseMapper;
    }

    public RespDto findById(Long id) throws NotFoundException {
        E entity = baseRepository.findById(id).orElseThrow(() -> new NotFoundException("Entity with ID " + id + " not found"));
        return baseMapper.entityToRespDto(entity);
    }

    public List<RespDto> findAll() {
        return baseRepository.findAll().stream().map(baseMapper::entityToRespDto).collect(Collectors.toList());
    }

    public RespDto create(ReqDto dto) {
        E entity = baseMapper.reqDtoToEntity(dto);
        return baseMapper.entityToRespDto(baseRepository.save(entity));
    }

    public RespDto update(ReqDto dto) throws NotFoundException {
        E saved = baseRepository.findById(dto.getId()).orElseThrow(() -> new NotFoundException("Entity with ID " + dto.getId() + " not found"));
        copyNonNullProperties(dto, saved);
        return baseMapper.entityToRespDto(baseRepository.save(saved));
    }

    public void deleteById(Long id) throws NotFoundException {
        baseRepository.findById(id).orElseThrow(() -> new NotFoundException("Entity with ID " + id + " not found"));
        baseRepository.deleteById(id);
    }

    public static void copyNonNullProperties(Object src, Object target) {
        BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
    }


    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
}
