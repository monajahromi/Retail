package io.bankmanagment.retail.customer;

import io.bankmanagment.base.controller.BaseRestController;
import io.bankmanagment.base.exception.NotFoundException;
import io.bankmanagment.base.service.IBaseService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController extends BaseRestController<CustomerEntity, CustomerDto, CustomerDto> {

    private final CustomerService customerService;

    public CustomerController(IBaseService<CustomerEntity, CustomerDto, CustomerDto> baseService, CustomerService customerService) {
        super(baseService);
        this.customerService = customerService;
    }

    @GetMapping("/{id}/details")
    public CustomerDto getDetailsById(@PathVariable Long id) throws NotFoundException {

        return customerService.getDetailsById(id);
    }
}
