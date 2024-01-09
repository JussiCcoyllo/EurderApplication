package com.switchfully.eurder.controller;

import com.switchfully.eurder.dto.itemDto.*;
import com.switchfully.eurder.service.AdminService;
import com.switchfully.eurder.service.ItemService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping(path = "/items")
public class ItemController {
    private final ItemService itemService;
    private final AdminService adminService;

    public ItemController(ItemService itemService, AdminService adminService) {
        this.itemService = itemService;
        this.adminService = adminService;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDto createItem(@RequestHeader String email, @RequestHeader String password, @Valid @RequestBody CreateItemDto createItemDto) {
        adminService.checkIfIsAdmin(email, password);

        return itemService.createItem(createItemDto);
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ItemDto findById(@PathVariable Long id) {

        return itemService.findById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ItemDto> findAllItems() {

        return itemService.findAllItems();
    }
    
    @PutMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDto updateItem(@RequestHeader String email, @RequestHeader String password, @PathVariable Long id, @Valid @RequestBody UpdateItemDto updateItemDto) {
        adminService.checkIfIsAdmin(email, password);

        return itemService.updateItem(id, updateItemDto);
    }

}
