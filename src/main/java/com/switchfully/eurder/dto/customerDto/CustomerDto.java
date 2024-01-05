package com.switchfully.eurder.dto.customerDto;


import lombok.*;


@Data
public class CustomerDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
}