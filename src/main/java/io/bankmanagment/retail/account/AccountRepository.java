package io.bankmanagment.retail.account;

import io.bankmanagment.base.repository.IBaseRepository;
import io.bankmanagment.retail.customer.CustomerEntity;

import java.util.List;

public interface AccountRepository<A extends AccountEntity> extends IBaseRepository<A> {

    List<AccountEntity> findByCustomer(CustomerEntity customerEntity);
}
