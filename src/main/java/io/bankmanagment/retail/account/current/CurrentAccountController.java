package io.bankmanagment.retail.account.current;

import io.bankmanagment.base.controller.BaseRestController;
import io.bankmanagment.base.service.IBaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account/current")
public class CurrentAccountController extends BaseRestController<CurrentAccountEntity, CurrentAccountDto,CurrentAccountDto> {

    public CurrentAccountController(IBaseService<CurrentAccountEntity, CurrentAccountDto, CurrentAccountDto> baseService) {
        super(baseService);
    }
}
