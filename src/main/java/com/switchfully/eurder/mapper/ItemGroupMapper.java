package com.switchfully.eurder.mapper;

import com.switchfully.eurder.dto.itemGroupDto.*;
import com.switchfully.eurder.entity.*;
import com.switchfully.eurder.exception.*;
import com.switchfully.eurder.repository.*;
import org.mapstruct.*;
import org.mapstruct.factory.*;
import org.springframework.stereotype.*;

import java.time.*;

@Component
public class ItemGroupMapper {

    public ItemGroupDto itemGroupToItemGroupDto(ItemGroup itemGroup) {
        return new ItemGroupDto(itemGroup.getIdItem(), itemGroup.getItemName(), itemGroup.getItemPrice(), itemGroup.getAmount(), itemGroup.getShippingDate());
    }
    public ItemGroup createItemGroupDtoToItemGroup(Item item, CreateItemGroupDto createItemGroupDto, LocalDate shippingDate) {
        return new ItemGroup(item.getId(), item.getName(), item.getPrice(), item.getPrice(), createItemGroupDto.getAmount(), shippingDate);
    }
    public CreateItemGroupDto itemGroupToCreateItemGroupDto(ItemGroup itemGroup) {
        return new CreateItemGroupDto(itemGroup.getIdItem(), itemGroup.getAmount());
    }

}