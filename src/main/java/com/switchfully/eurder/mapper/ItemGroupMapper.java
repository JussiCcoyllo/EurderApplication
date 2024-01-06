package com.switchfully.eurder.mapper;

import com.switchfully.eurder.dto.itemGroupDto.*;
import com.switchfully.eurder.entity.*;
import org.mapstruct.*;
import org.mapstruct.factory.*;

@Mapper(componentModel = "spring")
public interface ItemGroupMapper {

    ItemGroupMapper INSTANCE = Mappers.getMapper(ItemGroupMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "idItem", source = "idItem")
    @Mapping(target = "itemName", ignore = true) // Assuming you don't want to map itemName explicitly
    @Mapping(target = "itemPrice", ignore = true) // Assuming you don't want to map itemPrice explicitly
    @Mapping(target = "shippingDate", ignore = true) // Assuming you don't want to map shippingDate explicitly
    ItemGroup createItemGroupDtoToItemGroup(CreateItemGroupDto createItemGroupDto);


}