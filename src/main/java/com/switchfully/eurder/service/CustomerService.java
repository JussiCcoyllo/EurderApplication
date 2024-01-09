package com.switchfully.eurder.service;

import com.switchfully.eurder.dto.customerDto.*;
import com.switchfully.eurder.entity.*;
import com.switchfully.eurder.exception.*;
import com.switchfully.eurder.mapper.CustomerMapper;
import com.switchfully.eurder.repository.CustomerRepository;
import jakarta.transaction.*;
import lombok.*;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.*;
@RequiredArgsConstructor
@Service
public class CustomerService {
    @Autowired(required=true)
    private  CustomerMapper customerMapper;
    @Autowired(required=true)
    private CustomerRepository customerRepository;
    private  BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();


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
        Customer customer =  customerMapper.createCustomerDtoToCustomer(createCustomerDto);

        return customerMapper.customerToCustomerDto(customerRepository.save(customer));
    }
    public CustomerDto findById(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(CustomerIdNotFoundException::new);

        return customerMapper.customerToCustomerDto(customer);
    }

    public List<CustomerDto> findAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .map(CustomerMapper.INSTANCE::customerToCustomerDto)
                .collect(Collectors.toList());
    }

    public CustomerDto updateCustomer(Long id, UpdateCustomerDto updateCustomerDto)  {
        Customer customer = customerMapper.updateCustomerDtoToCustomer(updateCustomerDto, customerRepository.findById(id).orElseThrow(CustomerIdNotFoundException::new));

        return customerMapper.customerToCustomerDto(customerRepository.save(customer));
    }
}
