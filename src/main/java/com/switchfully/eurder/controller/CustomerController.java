package com.switchfully.eurder.controller;

import com.switchfully.eurder.dto.customerDto.CreateCustomerDto;
import com.switchfully.eurder.dto.customerDto.CustomerDto;
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
    public List<CustomerDto> findAllCustomers(@RequestHeader String email, @RequestHeader String password) {
        adminService.checkIfIsAdmin(email, password);

        return customerService.findAllCustomers();
    }

}
