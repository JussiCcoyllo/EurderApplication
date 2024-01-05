package com.switchfully.eurder.service;

import com.switchfully.eurder.dto.customerDto.*;
import com.switchfully.eurder.entity.*;
import com.switchfully.eurder.exception.*;
import com.switchfully.eurder.mapper.CustomerMapper;
import com.switchfully.eurder.repository.CustomerRepository;
import jakarta.transaction.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.*;

@Service
@Transactional
public class CustomerService {
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private CustomerRepository customerRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();


    public Customer checkIfIsCustomer(String email, String password) throws CustomerEmailNotFoundException {
        return checkIfPasswordIsValid(findByEmail(email),password);
    }

    private Customer checkIfPasswordIsValid(Customer customer, String password)  throws PasswordIsNotValidException {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if (!bCryptPasswordEncoder.matches(password, customer.getPassword())) {
            throw new PasswordIsNotValidException();
        }
        return customer;
    }

    private Customer findByEmail(String email) {
        return customerRepository.findByEmail(email).orElseThrow(CustomerEmailNotFoundException::new);
    }
    public CustomerDto createCustomer(CreateCustomerDto createCustomerDto) {
        createCustomerDto.setPassword(bCryptPasswordEncoder.encode(createCustomerDto.getPassword()));
        Customer customer =  customerMapper.mapCreateCustomerDtoToCustomer(createCustomerDto);

        return customerMapper.mapCustomerToCustomerDto(customerRepository.save(customer));
    }
    public CustomerDto findById(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(CustomerIdNotFoundException::new);

        return customerMapper.mapCustomerToCustomerDto(customer);
    }

    public List<CustomerDto> findAllCustomers() {
        return customerRepository.findAll().stream().map(customerMapper::mapCustomerToCustomerDto).collect(Collectors.toList());
    }
}
