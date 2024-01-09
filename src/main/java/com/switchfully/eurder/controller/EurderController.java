package com.switchfully.eurder.controller;

import com.switchfully.eurder.dto.eurderDto.*;
import com.switchfully.eurder.entity.*;
import com.switchfully.eurder.repository.CustomerRepository;
import com.switchfully.eurder.service.*;
import jakarta.validation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@Validated
@RequestMapping(path = "/eurders")
public class EurderController {

    private final CustomerService customerService;
    private final EurderService eurderService;
    private final CustomerRepository customerRepository;
    private final AdminService adminService;

    public EurderController(CustomerService customerService, EurderService eurderService, CustomerRepository customerRepository, AdminService adminService) {
        this.customerService = customerService;
        this.eurderService = eurderService;
        this.customerRepository = customerRepository;
        this.adminService = adminService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EurderDto createEurder(@RequestHeader String email, @RequestHeader String password, @Valid @RequestBody CreateEurderDto createEurderDto) {
        Customer customer= customerService.checkIfIsCustomer(email, password);
        return eurderService.createEurder(customer, createEurderDto);
    }

    @GetMapping
    public List<EurderDto> getEurders(@RequestHeader String email, @RequestHeader String password) {
        Customer customer = customerService.checkIfIsCustomer(email, password);

        return eurderService.getEurders();
    }

}
