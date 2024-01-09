package com.switchfully.eurder.mapper;

import com.switchfully.eurder.dto.itemDto.*;
import com.switchfully.eurder.entity.*;
import org.mapstruct.*;
import org.mapstruct.factory.*;
import org.springframework.stereotype.*;

@Component
public class ItemMapper {

    public final static int STOCK_LOW_LESS_THAN = 5;
    public final static int STOCK_MEDIUM_LESS_THAN = 10;

    public ItemDto itemToItemDto(Item item) {
        return new ItemDto(item.getId(), item.getName(), item.getDescription(), item.getPrice(), item.getStockAmount());
    }
    public Item createItemDtoToItem(CreateItemDto createItemDto){
        return new Item(createItemDto.getName(), createItemDto.getDescription(), createItemDto.getPrice(),createItemDto.getStockAmount());
    };
    public Item updateItemDtoToItem(Item item, UpdateItemDto updateItemDto) {
        item.setName(updateItemDto.getName());
        item.setDescription(updateItemDto.getDescription());
        item.setPrice(updateItemDto.getPrice());
        item.setStockAmount(updateItemDto.getStockAmount());

        return item;
    }

}