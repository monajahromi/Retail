package io.bankmanagment.retail.customer;

import io.bankmanagment.base.mapper.IBaseMapper;
import io.bankmanagment.base.model.dto.BaseDto;
import io.bankmanagment.base.model.entity.BaseEntity;
import io.bankmanagment.base.repository.IBaseRepository;
import io.bankmanagment.base.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends BaseService<CustomerEntity, CustomerDto, CustomerDto> {


    public CustomerService(IBaseRepository<CustomerEntity> baseRepository, IBaseMapper<CustomerEntity, CustomerDto, CustomerDto> baseMapper) {
        super(baseRepository, baseMapper);
    }
}
