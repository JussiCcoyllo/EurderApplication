package com.switchfully.eurder.dto.eurderDto;

import com.switchfully.eurder.dto.itemGroupDto.*;
import jakarta.validation.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
@Data
public class CreateEurderDto {
    @Valid
    private final List<CreateItemGroupDto> itemGroupList;
    @NotNull
    private final LocalDate eurderDate;

}
