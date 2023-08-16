package io.bankmanagment.retail.customer;

import io.bankmanagment.base.controller.BaseRestController;
import io.bankmanagment.base.exception.NotFoundException;
import io.bankmanagment.base.service.IBaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController extends BaseRestController<CustomerEntity, CustomerResponseDto, CustomerRequestDto> {

    private final CustomerService customerService;

    public CustomerController(IBaseService<CustomerEntity, CustomerResponseDto, CustomerRequestDto> baseService, CustomerService customerService) {
        super(baseService);
        this.customerService = customerService;
    }

    @GetMapping("/{id}/details")
    @Operation(summary = "Get details of a customer by ID")
    @Parameter(description = "ID of the customer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customer details retrieved successfully."),
            @ApiResponse(responseCode = "404", description = "Customer not found.")
    })
    public CustomerResponseDto getDetailsById(@PathVariable Long id) throws NotFoundException {
           return customerService.getDetailsById(id);
    }

    @Override
    @Operation(summary = "Retrieve Customer by ID")
    @Parameter(description = "ID of Customer to retrieve")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the Customer."),
            @ApiResponse(responseCode = "404", description = "Customer not found.")
    })
    public ResponseEntity<CustomerResponseDto> findById(@PathVariable(name = "id") Long id) throws NotFoundException {
        return super.findById(id);
    }


    @Override
    @Operation(summary = "Retrieve all Customers")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved all Customers.")
    public ResponseEntity<List<CustomerResponseDto>> findAll() {
        return super.findAll();
    }


    @Override
    @Operation(summary = "Create Customer")
    @Parameter(description = "Name and surname is needed for creating Customer.")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
            content = @Content(examples = {
                    @ExampleObject(name = "One", description = "Creating customer with name 'Mona', " +
                            "surname 'Jahromi'",
                            value = "{\"name\": \"Mona\",\n" +
                                    "    \"surname\" : \"Jahromi\"}")}))

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Customer created successfully."),
            @ApiResponse(responseCode = "400", description = "Name and surname can't be blank.")
    })
    public ResponseEntity<CustomerResponseDto> create(@RequestBody @Valid CustomerRequestDto dto) {
        return super.create(dto);
    }

    @Override
    @Operation(summary = "Update customer details")
    @Parameter(description = "'name' and 'surname' fields would be updated if provided.")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
            content = @Content(examples = {
                    @ExampleObject(name = "One", description = "Updating customer with id '1'" ,
                            value = "{\n" +
                                    "    \"id\": 1,\n" +
                                    "    \"name\": \"Hana\",\n" +
                                    "    \"surname\": \"Jahromi\"\n" +
                                    "}")}))

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customer updated successfully."),
            @ApiResponse(responseCode = "404", description = "Customer not found")
    })
    public ResponseEntity<CustomerResponseDto> update(@RequestBody CustomerRequestDto dto) throws NotFoundException {
        return super.update(dto);
    }


    @Override
    @Operation(summary = "Delete Customer with ID")
    @Parameter(description = "Delete Customer by its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customer deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Customer not found")
    })
    public ResponseEntity<Void> deleteById(@PathVariable(name = "id") Long id) throws NotFoundException {
        return super.deleteById(id);
    }
}
