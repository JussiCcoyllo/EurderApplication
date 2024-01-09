package com.switchfully.eurder.dto.eurderDto;

import com.switchfully.eurder.dto.itemGroupDto.*;
import com.switchfully.eurder.entity.Customer;
import com.switchfully.eurder.entity.ItemGroup;
import jakarta.persistence.*;
import lombok.*;

import java.time.*;
import java.util.List;

@Data
@NoArgsConstructor
public class EurderDto {
    private Long id;
    private Long idCustomer;
    private List<ItemGroup> itemGroups;
    private double totalPrice;
    private LocalDate orderDate;

    public EurderDto( Long idCustomer, List<ItemGroup> itemGroups, double totalPrice, LocalDate orderDate) {

        this.idCustomer = idCustomer;
        this.itemGroups = itemGroups;
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
    }

    public EurderDto(Long id, Long idCustomer, double totalPrice, LocalDate orderDate) {
        this.id = id;
        this.idCustomer = idCustomer;
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
    }


    public EurderDto(Long id, Long idCustomer, List<ItemGroupDto> itemGroupDtos, double totalPrice, LocalDate orderDate) {
    }
}
