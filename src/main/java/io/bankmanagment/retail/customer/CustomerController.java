package io.bankmanagment.retail.customer;

import io.bankmanagment.base.controller.BaseRestController;
import io.bankmanagment.base.exception.NotFoundException;
import io.bankmanagment.base.service.IBaseService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController extends BaseRestController<CustomerEntity, CustomerResponseDto, CustomerRequestDto> {

    private final CustomerService customerService;

    public CustomerController(IBaseService<CustomerEntity, CustomerResponseDto, CustomerRequestDto> baseService, CustomerService customerService) {
        super(baseService);
        this.customerService = customerService;
    }

    @GetMapping("/{id}/details")
    public CustomerResponseDto getDetailsById(@PathVariable Long id) throws NotFoundException {

        return customerService.getDetailsById(id);
    }
}
