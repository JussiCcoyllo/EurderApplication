package com.switchfully.eurder.service;

import com.switchfully.eurder.dto.itemDto.*;
import com.switchfully.eurder.entity.*;
import com.switchfully.eurder.exception.*;
import com.switchfully.eurder.mapper.ItemMapper;
import com.switchfully.eurder.repository.ItemRepository;
import jakarta.transaction.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.*;

@Service
@Transactional
public class ItemService {
    @Autowired
    private ItemMapper itemMapper;
    @Autowired
    private ItemRepository itemRepository;

    public ItemDto createItem(CreateItemDto createItemDto) {
        Item item = itemMapper.createItemDtoToItem(createItemDto);
        return itemMapper.itemToItemDto(itemRepository.save(item));
    }


    public List<ItemDto> findAllItems() {
        List<Item> items = itemRepository.findAll();
        return items.stream()
                .map(ItemMapper.INSTANCE::itemToItemDto)
                .collect(Collectors.toList());
    }

    public ItemDto findById(Long itemId) {
        Item item = itemRepository.findById(itemId).orElseThrow(ItemIdNotFoundException::new);

        return itemMapper.itemToItemDto(item);
    }

    public void updateItem(Long itemId, UpdateItemDto updateItemDto) {
        Optional<Item> optionalItem = itemRepository.findById(itemId);
        optionalItem.ifPresent(item -> {
            ItemMapper.INSTANCE.updateItemDtoToItem(updateItemDto, item);
            itemRepository.save(item);
        });
    }
}
