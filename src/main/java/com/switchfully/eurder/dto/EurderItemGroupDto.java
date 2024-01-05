package com.switchfully.eurder.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.UUID;
@Data
public class EurderItemGroupDto {
    private Long id;
    private String itemName;
    private Double itemPrice;
    private Integer amount;
    private LocalDate shippingDate;

}
