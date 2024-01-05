package com.switchfully.eurder.service;

import com.switchfully.eurder.dto.itemDto.*;
import com.switchfully.eurder.mapper.ItemMapper;
import com.switchfully.eurder.repository.ItemRepository;
import jakarta.transaction.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Transactional
public class ItemService {
    @Autowired
    private ItemMapper itemMapper;
    @Autowired
    private ItemRepository itemRepository;


    public ItemDto createItem(CreateItemDto createItemDto) {
    }

    public ItemDto finById(Long id) {
    }

    public List<ItemDto> findAllItems() {
    }
}
