package com.switchfully.eurder.service;

import com.switchfully.eurder.dto.*;
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


}
