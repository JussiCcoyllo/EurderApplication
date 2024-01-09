package com.switchfully.eurder.mapper;

import com.switchfully.eurder.dto.eurderDto.*;
import com.switchfully.eurder.dto.itemGroupDto.*;
import com.switchfully.eurder.entity.*;
import org.mapstruct.*;
import org.mapstruct.factory.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class EurderMapper{

    private final ItemGroupMapper itemGroupMapper;

    public EurderMapper(ItemGroupMapper itemGroupMapper) {
        this.itemGroupMapper = itemGroupMapper;
    }

    public  EurderDto eurderToEurderDto(Eurder eurder) {
        List<ItemGroupDto> itemGroupDtos = eurder.getItemGroups()
                .stream()
                .map(itemGroupMapper::itemGroupToItemGroupDto)
                .toList();

        return new EurderDto(eurder.getId(),
                        eurder.getIdCustomer(),
                        eurder.getTotalPrice(),
                        eurder.getOrderDate());
    }
    public Eurder createEurderDtoToEurder(CreateEurderDto createEurderDto){
        return null;
    }



}
