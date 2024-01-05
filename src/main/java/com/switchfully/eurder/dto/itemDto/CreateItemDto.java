package com.switchfully.eurder.dto.itemDto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
public class CreateItemDto {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotNull
    private Double price;
    @NotNull
    private Integer stockAmount;


}