package io.bankmanagment.retail.transaction;

import io.bankmanagment.base.mapper.IBaseMapper;
import io.bankmanagment.base.repository.IBaseRepository;
import io.bankmanagment.base.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class TransactionService extends BaseService<TransactionEntity, TransactionDto, TransactionDto> {


    public TransactionService(IBaseRepository<TransactionEntity> baseRepository, IBaseMapper<TransactionEntity, TransactionDto, TransactionDto> baseMapper) {
        super(baseRepository, baseMapper);
    }
}
