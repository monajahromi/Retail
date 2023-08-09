package io.bankmanagment.base.service;



import io.bankmanagment.base.mapper.IBaseMapper;
import io.bankmanagment.base.model.entity.BaseEntity;
import io.bankmanagment.base.exception.NotFoundException;
import io.bankmanagment.base.model.dto.BaseDto;
import io.bankmanagment.base.repository.IBaseRepository;

import java.util.List;

public class BaseService<T extends BaseEntity, GD extends BaseDto, PD extends BaseDto> implements IBaseService<T, GD, PD>{
    public IBaseRepository<T> baseRepository;
    public IBaseMapper<T, GD, PD> baseMapper;

    public BaseService(IBaseRepository<T> baseRepository, IBaseMapper<T, GD, PD> baseMapper) {
        this.baseRepository = baseRepository;
        this.baseMapper = baseMapper;
    }

    public GD findById(Long id) throws NotFoundException {
        T entity = baseRepository.findById(id).orElseThrow(NotFoundException::new);
        return baseMapper.entityToGetDto(entity);
    }

    public List<GD> findAll() {
        List<T> all = baseRepository.findAll();
        return all.stream().map(baseMapper::entityToGetDto).toList();
    }

    public GD create(PD dto) {
        T entity = baseMapper.postDtoToEntity(dto);
        return baseMapper.entityToGetDto(baseRepository.save(entity));
    }

    public GD update(Long id, PD dto) throws NotFoundException {
        T existed = baseRepository.findById(id).orElseThrow(NotFoundException::new);
        return baseMapper.entityToGetDto(baseRepository.save(existed));
    }

    public void deleteById(Long id) {
        baseRepository.deleteById(id);
    }
}
