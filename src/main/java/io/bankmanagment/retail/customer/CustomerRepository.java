package io.bankmanagment.retail.customer;

import io.bankmanagment.base.repository.IBaseRepository;

public interface CustomerRepository extends IBaseRepository<CustomerEntity> {

     CustomerEntity findByCode(String code) ;
}
