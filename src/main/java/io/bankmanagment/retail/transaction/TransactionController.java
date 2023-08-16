package io.bankmanagment.retail.transaction;

import io.bankmanagment.base.controller.BaseRestController;
import io.bankmanagment.base.exception.CustomMethodNotAllowedException;
import io.bankmanagment.base.exception.NotFoundException;
import io.bankmanagment.base.service.IBaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public ResponseEntity<Void> deleteById(@PathVariable(name = "id") Long id) throws NotFoundException {
        throw new CustomMethodNotAllowedException();
    }



    @Override
    @Operation(summary = "Retrieve all Transactions")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved all transactions")
    public ResponseEntity<List<TransactionResponseDto>> findAll() {
        return super.findAll();
    }

    @Override
    @Operation(summary = "Retrieve Transaction by ID")
    @Parameter(description = "ID of the Transaction to retrieve")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the Transaction"),
            @ApiResponse(responseCode = "400", description = "Transaction not found")
    })
    public ResponseEntity<TransactionResponseDto> findById(@PathVariable(name = "id") Long id)
            throws NotFoundException {
        return super.findById(id);
    }
}
