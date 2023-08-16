package io.bankmanagment.retail.transaction;

import io.bankmanagment.base.controller.BaseRestController;
import io.bankmanagment.base.exception.CustomMethodNotAllowedException;
import io.bankmanagment.base.exception.NotFoundException;
import io.bankmanagment.base.service.IBaseService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController extends BaseRestController<TransactionEntity, TransactionResponseDto, TransactionRequestDto> {


    public TransactionController(IBaseService<TransactionEntity, TransactionResponseDto, TransactionRequestDto> baseService) {
        super(baseService);
    }



    @Override
    @Operation(hidden = true)
    public ResponseEntity<TransactionResponseDto> update(TransactionRequestDto dto) throws NotFoundException {
        throw new CustomMethodNotAllowedException();
    }

    @Override
    @Operation(hidden = true)
    public ResponseEntity<TransactionResponseDto> create(TransactionRequestDto dto) {
        throw new CustomMethodNotAllowedException();
    }

    @Override
    @Operation(hidden = true)
    public ResponseEntity<Void> deleteById(Long id) throws NotFoundException {
        throw new CustomMethodNotAllowedException();
    }
}
