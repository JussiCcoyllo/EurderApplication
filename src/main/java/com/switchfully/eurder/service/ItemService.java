package com.switchfully.eurder.service;

import com.switchfully.eurder.dto.itemDto.*;
import com.switchfully.eurder.entity.*;
import com.switchfully.eurder.exception.*;
import com.switchfully.eurder.mapper.ItemMapper;
import com.switchfully.eurder.repository.ItemRepository;
import jakarta.transaction.*;
import lombok.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.*;
@RequiredArgsConstructor
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
        return itemRepository.findAll().stream().map(itemMapper::itemToItemDto).collect(Collectors.toList());
    }

    public ItemDto findById(Long itemId) {
        Item item = itemRepository.findById(itemId).orElseThrow(ItemIdNotFoundException::new);

        return itemMapper.itemToItemDto(item);
    }

    public ItemDto updateItem(Long id, UpdateItemDto updateItemDto) throws ItemIdNotFoundException {
        Item item = itemMapper.updateItemDtoToItem(itemRepository.findById(id).orElseThrow(ItemIdNotFoundException::new), updateItemDto);

        return itemMapper.itemToItemDto(itemRepository.save(item));
    }

}
