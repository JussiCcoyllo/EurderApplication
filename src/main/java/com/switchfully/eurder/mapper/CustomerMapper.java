package com.switchfully.eurder.mapper;

import com.switchfully.eurder.dto.customerDto.*;
import com.switchfully.eurder.entity.*;
import org.mapstruct.*;
import org.mapstruct.factory.*;
import org.springframework.stereotype.*;


@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerDto customerToCustomerDto(Customer customer);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "password", ignore = true)
    Customer createCustomerDtoToCustomer(CreateCustomerDto createCustomerDto);

    @Mapping(target = "id", ignore = true)
    Customer updateCustomerDtoToCustomer(UpdateCustomerDto updateCustomerDto, @MappingTarget Customer customer);


}
