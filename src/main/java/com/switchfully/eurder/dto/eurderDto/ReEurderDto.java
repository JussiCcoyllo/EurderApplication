package com.switchfully.eurder.dto.eurderDto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReEurderDto {
    @NotNull
    private LocalDate orderDate;

}
