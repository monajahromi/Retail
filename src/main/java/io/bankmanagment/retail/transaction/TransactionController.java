package io.bankmanagment.retail.transaction;

import io.bankmanagment.base.controller.BaseRestController;
import io.bankmanagment.base.service.IBaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController extends BaseRestController<TransactionEntity, TransactionResponseDto, TransactionRequestDto> {


    public TransactionController(IBaseService<TransactionEntity, TransactionResponseDto, TransactionRequestDto> baseService) {
        super(baseService);
    }
}
