package io.bankmanagment.retail.account.current;

import io.bankmanagment.base.controller.BaseRestController;
import io.bankmanagment.base.exception.NotFoundException;
import io.bankmanagment.base.service.IBaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/accounts/current")
@Schema(description = "Current Account Management")
public class CurrentAccountController extends BaseRestController<CurrentAccountEntity, CurrentAccountResponseDto, CurrentAccountRequestDto> {

    private final CurrentAccountService currentAccountService;

    public CurrentAccountController(IBaseService<CurrentAccountEntity, CurrentAccountResponseDto, CurrentAccountRequestDto> baseService, CurrentAccountService currentAccountService) {
        super(baseService);
        this.currentAccountService = currentAccountService;
    }


    @Override
    @Operation(summary = "Retrieve all Current Accounts")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved all current accounts")
    public ResponseEntity<List<CurrentAccountResponseDto>> findAll() {
        return super.findAll();
    }

    @Override
    @Operation(summary = "Retrieve Current Account by ID")
    @Parameter(description = "ID of the current account to retrieve")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the current account"),
            @ApiResponse(responseCode = "404", description = "Account not found")
    })
    public ResponseEntity<CurrentAccountResponseDto> findById(@PathVariable(name = "id") Long id)
            throws NotFoundException {
        return super.findById(id);
    }

    @Override
    @Operation(summary = "Update Current Account")
    @Parameter(description = "'balanceFloor' and 'chequeBookAvailable' fields would be updated if provided.")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
            content = @Content(examples = {
                    @ExampleObject(name = "One", description = "Updating account with id '4', " +
                            "Setting balance floor to 10000, Setting cheque book availability to true",
                            value = "{\"id\": 4, \"balanceFloor\": 10000, " +
                                    " \"chequeBookAvailable\": true}")}))

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Account updated successfully"),
            @ApiResponse(responseCode = "404", description = "Account not found")
    })
    public ResponseEntity<CurrentAccountResponseDto> update(
            @RequestBody CurrentAccountRequestDto dto) throws NotFoundException {
        return super.update(dto);
    }

    @Override
    @Operation(summary = "Create Current Account")
    @Parameter(description = "Initial account credit and customer Id is needed for creating current account.")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
            content = @Content(examples = {
                    @ExampleObject(name = "One", description = "Creating current account for customer with id '1', " +
                            "Setting initial credit to 4200000",
                            value = "{\"initialCredit\":4200000,\"customerID\" :1\n}")}))

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Account created successfully"),
            @ApiResponse(responseCode = "404", description = "Customer not found")
    })
    public ResponseEntity<CurrentAccountResponseDto> create(@RequestBody @Valid CurrentAccountRequestDto dto) {
        return super.create(dto);
    }


    @Override
    @Operation(summary = "Delete current account with ID")
    @Parameter(description = "Delete a current account by its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Account deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Account not found")
    })
    public ResponseEntity<Void> deleteById(@PathVariable(name = "id") Long id) throws NotFoundException {
        return super.deleteById(id);
    }
}
