package com.switchfully.eurder.service;

import com.switchfully.eurder.dto.customerDto.*;
import com.switchfully.eurder.dto.eurderDto.*;
import com.switchfully.eurder.dto.itemGroupDto.*;
import com.switchfully.eurder.entity.*;
import com.switchfully.eurder.exception.*;
import com.switchfully.eurder.mapper.ItemGroupMapper;
import com.switchfully.eurder.mapper.EurderMapper;
import com.switchfully.eurder.repository.EurderRepository;
import com.switchfully.eurder.repository.ItemRepository;
import jakarta.transaction.*;
import lombok.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.*;
import java.util.stream.*;

@RequiredArgsConstructor
@Service
public class EurderService {
    @Autowired(required = true)
    private EurderMapper eurderMapper;
    @Autowired
    private EurderRepository eurderRepository;
    @Autowired
    private ItemGroupMapper itemGroupMapper;
    @Autowired
    private ItemRepository itemRepository;

    public EurderDto createEurder(Customer customer, CreateEurderDto createEurderDto) {
        Eurder eurder = eurderMapper.createEurderDtoToEurder(createEurderDto);
        return eurderMapper.eurderToEurderDto(eurderRepository.save(eurder));
    }
    private ItemGroup createItemGroup(CreateEurderDto createEurderDto, CreateItemGroupDto createItemGroupDto) {
        Item item = itemRepository.findById(createItemGroupDto.getId_item()).orElseThrow(ItemIdNotFoundException::new);
        LocalDate shippingDate = calculateShippingDate(item, createItemGroupDto.getAmount(), createEurderDto.getEurderDate());

        return itemGroupMapper.createItemGroupDtoToItemGroup(item, createItemGroupDto, shippingDate);
    }
    private List<ItemGroup> createItemGroupList(CreateEurderDto createEurderDto) {
        return createEurderDto.getItemGroupList().stream()
                .map(createItemGroupDto -> createItemGroup(createEurderDto, createItemGroupDto))
                .toList();
    }


    private LocalDate calculateShippingDate(Item item, Integer stockAmount, LocalDate eurderDate) {
        return (stockAmount > 0) ? LocalDate.now().plusDays(1) : LocalDate.now().plusDays(7);
    }
    private double calculateTotalPrice(List<ItemGroup> itemGroups) {
        return itemGroups.stream()
                .mapToDouble(itemGroup -> itemGroup.getItemPrice() * itemGroup.getAmount())
                .sum();
    }
    public EurderDto findById(Long id) throws ItemIdNotFoundException {
        Eurder eurder = eurderRepository.findById(id).orElseThrow(ItemIdNotFoundException::new);

        return eurderMapper.eurderToEurderDto(eurder);
    }

    public List<EurderDto> findAllEurders(Customer customer) {
        return eurderRepository.findById(customer.getId()).stream().map(eurderMapper::eurderToEurderDto).collect(Collectors.toList());
    }
    public List<EurderDto> getEurders() {
        return eurderRepository.findAll().stream()
                .map(order -> eurderMapper.eurderToEurderDto(order))
                .collect(Collectors.toList());
    }

}
