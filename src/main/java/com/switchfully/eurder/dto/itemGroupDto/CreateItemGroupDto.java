package com.switchfully.eurder.dto.itemGroupDto;



import jakarta.validation.constraints.*;
import lombok.*;

@Data
@Builder

@NoArgsConstructor
public class CreateItemGroupDto {
    @NotNull
    private Long id_item;
    @NotNull
    private Integer amount;

    public CreateItemGroupDto(Long id_item, Integer amount) {
        this.id_item = id_item;
        this.amount = amount;
    }
}
