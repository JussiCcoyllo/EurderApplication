package com.switchfully.eurder.service;

import com.switchfully.eurder.dto.customerDto.*;
import com.switchfully.eurder.dto.eurderDto.*;
import com.switchfully.eurder.entity.*;
import com.switchfully.eurder.mapper.ItemGroupMapper;
import com.switchfully.eurder.mapper.EurderMapper;
import com.switchfully.eurder.repository.EurderRepository;
import com.switchfully.eurder.repository.ItemRepository;
import jakarta.transaction.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.*;
import java.util.stream.*;


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



    public EurderDto createEurder(Customer customer, CreateEurderDto createEurderDto) {

        Eurder eurder = eurderMapper.createEurderDtoToEurder(customer, createEurderDto);
        return eurderMapper.eurderToEurderDto(eurderRepository.save(eurder), customer);
    }
    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customerMapper.customersToCustomerDtos(customers);
    }
    private List<ItemGroup> createItemGroups(List<Item> selectedItems) {
        return selectedItems.stream()
                .map(item -> {
                    ItemGroup itemGroup = new ItemGroup();
                    itemGroup.setIdItem(item.getId());
                    itemGroup.setItemName(item.getName());
                    itemGroup.setItemPrice(item.getPrice());
                    itemGroup.setAmount(1);
                    itemGroup.setShippingDate(calculateShippingDate(item.getStockAmount()));
                    return itemGroup;
                })
                .collect(Collectors.toList());
    }

    private LocalDate calculateShippingDate(Integer stockAmount) {
        return (stockAmount > 0) ? LocalDate.now().plusDays(1) : LocalDate.now().plusDays(7);
    }
    private double calculateTotalPrice(List<ItemGroup> itemGroups) {
        return itemGroups.stream()
                .mapToDouble(itemGroup -> itemGroup.getItemPrice() * itemGroup.getAmount())
                .sum();
    }
}
