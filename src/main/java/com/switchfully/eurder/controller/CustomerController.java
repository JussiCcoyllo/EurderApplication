package com.switchfully.eurder.controller;

import com.switchfully.eurder.dto.customerDto.*;
import com.switchfully.eurder.mapper.*;
import com.switchfully.eurder.service.AdminService;
import com.switchfully.eurder.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping(path = "/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private CustomerMapper customerMapper;

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDto createCustomer(@Valid @RequestBody CreateCustomerDto createCustomerDto) {
        return customerService.createCustomer(createCustomerDto);
    }

    @GetMapping("/{id}")
    public CustomerDto getCustomerById(@RequestHeader String email, @RequestHeader String password, @PathVariable Long id) {
        adminService.checkIfIsAdmin(email, password);

        return customerService.findById(id);
    }
    @GetMapping
    public List<CustomerDto> getAllCustomers(@RequestHeader String email, @RequestHeader String password) {
        adminService.checkIfIsAdmin(email, password);

        return customerService.findAllCustomers();
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDto updateCustomer(@RequestHeader String email, @RequestHeader String password, @PathVariable Long id, @Valid @RequestBody UpdateCustomerDto updateCustomerDto) {
        adminService.checkIfIsAdmin(email, password);

        return customerService.updateCustomer(id, updateCustomerDto);
    }
}
