package io.bankmanagment.retail.transaction;

import io.bankmanagment.base.repository.IBaseRepository;
import io.bankmanagment.retail.account.AccountEntity;

import java.util.List;

public interface TransactionRepository extends IBaseRepository<TransactionEntity> {
    List<TransactionEntity> findByAccount(AccountEntity accountEntity) ;
}
