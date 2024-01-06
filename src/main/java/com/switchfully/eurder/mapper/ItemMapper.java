package com.switchfully.eurder.mapper;

import com.switchfully.eurder.dto.itemDto.*;
import com.switchfully.eurder.entity.*;
import org.mapstruct.*;
import org.mapstruct.factory.*;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    ItemMapper INSTANCE = Mappers.getMapper(ItemMapper.class);

    ItemDto itemToItemDto(Item item);


    @Mapping(target = "id", ignore = true)
    Item updateItemDtoToItem(UpdateItemDto updateItemDto, @MappingTarget Item item);

    @Mapping(target = "id", ignore = true)
    Item createItemDtoToItem(CreateItemDto createItemDto);

}