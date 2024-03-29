package com.switchfully.eurder.dto.itemDto;

import lombok.*;

import java.util.Objects;
import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer stockAmount;

}
