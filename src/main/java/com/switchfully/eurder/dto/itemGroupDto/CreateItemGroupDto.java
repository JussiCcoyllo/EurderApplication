package com.switchfully.eurder.dto.itemGroupDto;



import jakarta.validation.constraints.*;
import lombok.*;

@Data
public class CreateItemGroupDto {
    @NotNull
    private Long id_item;
    @NotNull
    private Integer amount;

}
