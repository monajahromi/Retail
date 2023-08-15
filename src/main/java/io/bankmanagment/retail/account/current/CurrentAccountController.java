package io.bankmanagment.retail.account.current;

import io.bankmanagment.base.controller.BaseRestController;
import io.bankmanagment.base.service.IBaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts/current")
public class CurrentAccountController extends BaseRestController<CurrentAccountEntity, CurrentAccountResponseDto, CurrentAccountRequestDto> {

    private final CurrentAccountService currentAccountService;

    public CurrentAccountController(IBaseService<CurrentAccountEntity, CurrentAccountResponseDto, CurrentAccountRequestDto> baseService, CurrentAccountService currentAccountService) {
        super(baseService);
        this.currentAccountService = currentAccountService;
    }

}
