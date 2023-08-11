package io.bankmanagment.retail.transaction;

import io.bankmanagment.base.controller.BaseRestController;
import io.bankmanagment.base.service.IBaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController extends BaseRestController<TransactionEntity, TransactionDto, TransactionDto> {


    public TransactionController(IBaseService<TransactionEntity, TransactionDto, TransactionDto> baseService) {
        super(baseService);
    }
}
