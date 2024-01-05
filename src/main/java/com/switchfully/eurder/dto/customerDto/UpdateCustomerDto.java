package com.switchfully.eurder.dto.customerDto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
public class UpdateCustomerDto {
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    private String phoneNumber;
    @NotBlank
    private String address;
}
