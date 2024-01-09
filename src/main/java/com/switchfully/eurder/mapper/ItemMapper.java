package com.switchfully.eurder.mapper;

import com.switchfully.eurder.dto.itemDto.*;
import com.switchfully.eurder.entity.*;
import org.mapstruct.*;
import org.mapstruct.factory.*;
import org.springframework.stereotype.*;

@Component
public class ItemMapper {

    ItemDto itemToItemDto(Item item);



    Item updateItemDtoToItem(UpdateItemDto updateItemDto

    Item createItemDtoToItem(CreateItemDto createItemDto);

}