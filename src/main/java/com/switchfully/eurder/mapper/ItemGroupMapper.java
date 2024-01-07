package com.switchfully.eurder.mapper;

import com.switchfully.eurder.dto.itemGroupDto.*;
import com.switchfully.eurder.entity.*;
import org.mapstruct.*;
import org.mapstruct.factory.*;

import java.time.*;

@Mapper(componentModel = "spring")
public interface ItemGroupMapper {

    ItemGroupMapper INSTANCE = Mappers.getMapper(ItemGroupMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "idItem", source = "idItem")
    @Mapping(target = "itemName", ignore = true)
    @Mapping(target = "itemPrice", ignore = true)
    @Mapping(target = "shippingDate", ignore = true)
    ItemGroup createItemGroupDtoToItemGroup(Item item, CreateItemGroupDto createItemGroupDto, LocalDate shippingDate);


}