package com.switchfully.eurder.controller;

import com.switchfully.eurder.dto.eurderDto.*;
import com.switchfully.eurder.entity.*;
import com.switchfully.eurder.repository.CustomerRepository;
import com.switchfully.eurder.service.CustomerService;
import com.switchfully.eurder.service.EurderService;
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
    @Autowired
    private CustomerService customerService;
    @Autowired
    private EurderService eurderService;
    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EurderDto createEurder(@RequestHeader String email, @RequestHeader String password, @Valid @RequestBody CreateEurderDto createEurderDto) {
        Customer customer= customerService.checkIfIsCustomer(email, password);
        return eurderService.createEurder(customer, createEurderDto);
    }

    @GetMapping
    public List<EurderDto> findAllOrdersForCustomer(@RequestHeader String email, @RequestHeader String password) {
        Customer customer = customerService.checkIfIsCustomer(email, password);

        return eurderService.findAllOrdersForCustomer(customer);
    }
}
