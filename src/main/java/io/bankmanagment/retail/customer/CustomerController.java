package io.bankmanagment.retail.customer;

import io.bankmanagment.base.controller.BaseRestController;
import io.bankmanagment.base.model.dto.BaseDto;
import io.bankmanagment.base.model.entity.BaseEntity;
import io.bankmanagment.base.service.IBaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController extends BaseRestController<CustomerEntity , CustomerDto,CustomerDto> {


    public CustomerController(IBaseService<CustomerEntity, CustomerDto, CustomerDto> baseService) {
        super(baseService);
    }
}
