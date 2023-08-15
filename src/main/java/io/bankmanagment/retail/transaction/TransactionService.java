package io.bankmanagment.retail.transaction;

import io.bankmanagment.base.mapper.IBaseMapper;
import io.bankmanagment.base.repository.IBaseRepository;
import io.bankmanagment.base.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class TransactionService extends BaseService<TransactionEntity, TransactionResponseDto, TransactionRequestDto> {


    public TransactionService(IBaseRepository<TransactionEntity> baseRepository, IBaseMapper<TransactionEntity, TransactionResponseDto, TransactionRequestDto> baseMapper) {
        super(baseRepository, baseMapper);
    }
}
