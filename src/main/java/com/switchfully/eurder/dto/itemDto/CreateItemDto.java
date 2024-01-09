package com.switchfully.eurder.dto.itemDto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
public class CreateItemDto {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotNull
    private Double price;
    @NotNull
    private Integer stockAmount;

    public CreateItemDto(String name, String description, Double price, Integer stockAmount) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stockAmount = stockAmount;
    }
}
