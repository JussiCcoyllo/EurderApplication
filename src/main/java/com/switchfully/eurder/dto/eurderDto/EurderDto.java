package com.switchfully.eurder.dto.eurderDto;

import com.switchfully.eurder.entity.Customer;
import com.switchfully.eurder.entity.ItemGroup;
import jakarta.persistence.*;
import lombok.*;

import java.time.*;
import java.util.List;

@Data
public class EurderDto {
    private Long id;
    private Long idCustomer;
    private List<ItemGroup> itemGroups;
    private double totalPrice;
    private LocalDate orderDate;

}
