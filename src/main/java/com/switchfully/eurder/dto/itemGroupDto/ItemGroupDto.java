package com.switchfully.eurder.dto.itemGroupDto;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemGroupDto {
    private Long id;
    private String itemName;
    private Double itemPrice;
    private Integer amount;
    private LocalDate shippingDate;

}
