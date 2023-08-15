package io.bankmanagment.retail.account.current;

import io.bankmanagment.base.controller.BaseRestController;
import io.bankmanagment.base.exception.NotFoundException;
import io.bankmanagment.base.service.IBaseService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts/current")
public class CurrentAccountController extends BaseRestController<CurrentAccountEntity, CurrentAccountDto, CurrentAccountDto> {

    private final CurrentAccountService currentAccountService;

    public CurrentAccountController(IBaseService<CurrentAccountEntity, CurrentAccountDto, CurrentAccountDto> baseService, CurrentAccountService currentAccountService) {
        super(baseService);
        this.currentAccountService = currentAccountService;
    }

    @PostMapping("/initialcredit")
    public void createCurrentAccount(@RequestBody CreateAccountRequestDto requestDto) throws NotFoundException {
        currentAccountService.createWithInitialCredit(requestDto) ;
    }
}
