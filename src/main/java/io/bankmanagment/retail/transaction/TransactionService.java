package io.bankmanagment.retail.transaction;

import io.bankmanagment.base.exception.NotFoundException;
import io.bankmanagment.base.mapper.IBaseMapper;
import io.bankmanagment.base.repository.IBaseRepository;
import io.bankmanagment.base.service.BaseService;
import io.bankmanagment.retail.account.AccountDto;
import io.bankmanagment.retail.account.AccountService;
import org.springframework.stereotype.Service;

@Service
public class TransactionService extends BaseService<TransactionEntity, TransactionDto, TransactionDto> {

    private final AccountService accountService;
    public TransactionService(IBaseRepository<TransactionEntity> baseRepository, IBaseMapper<TransactionEntity, TransactionDto, TransactionDto> baseMapper, AccountService accountService) {
        super(baseRepository, baseMapper);
        this.accountService = accountService;
    }

    @Override
    public TransactionDto create(TransactionDto transactionDto) {
        AccountDto accountDto;
        try {
            accountDto = (AccountDto) accountService.findById(transactionDto.getAccount().getId());
        } catch (NotFoundException e) {
            throw new RuntimeException("account with this id not found!");
        }
        transactionDto.setAccount(accountDto);
        return super.create(transactionDto);

    }
}
