package com.switchfully.eurder.dto;

import com.switchfully.eurder.entity.Customer;
import com.switchfully.eurder.entity.ItemGroup;
import lombok.*;

import java.util.List;

@Data
public class EurderDto {
    private Long id;
    private Customer customer;
    private  List<ItemGroup> itemGroups;
    private double totalPrice;

}
