package com.switchfully.eurder.mapper;

import com.switchfully.eurder.dto.customerDto.*;
import com.switchfully.eurder.entity.*;
import org.springframework.stereotype.*;


@Component
public class CustomerMapper {


   public CustomerDto customerToCustomerDto(Customer customer) {
        return new CustomerDto(customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getPhoneNumber(),
                customer.getAddress());
    }

    public Customer createCustomerDtoToCustomer(CreateCustomerDto createCustomerDto) {
        return new Customer(createCustomerDto.getFirstName(),
                createCustomerDto.getLastName(),
                createCustomerDto.getEmail(),
                createCustomerDto.getPassword(),
                createCustomerDto.getPhoneNumber(),
                createCustomerDto.getAddress());
    }

    public Customer updateCustomerDtoToCustomer(Customer customer, UpdateCustomerDto updateCustomerDto){
                customer.setFirstName(updateCustomerDto.getFirstName());
                customer.setLastName(updateCustomerDto.getLastName());
                customer.setEmail(updateCustomerDto.getEmail());
                customer.setPassword(updateCustomerDto.getPassword());
                customer.setPhoneNumber(updateCustomerDto.getPhoneNumber());
                customer.setAddress(updateCustomerDto.getAddress());
        return customer;
    }

}
