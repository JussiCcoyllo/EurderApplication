package com.switchfully.eurder.service;

import com.switchfully.eurder.dto.*;
import com.switchfully.eurder.entity.*;
import com.switchfully.eurder.mapper.ItemGroupMapper;
import com.switchfully.eurder.mapper.EurderMapper;
import com.switchfully.eurder.repository.EurderRepository;
import com.switchfully.eurder.repository.ItemRepository;
import jakarta.transaction.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
@Transactional
public class EurderService {
    @Autowired
    private EurderMapper eurderMapper;
    @Autowired
    private EurderRepository eurderRepository;
    @Autowired
    private ItemGroupMapper itemGroupMapper;
    @Autowired
    private ItemRepository itemRepository;




}