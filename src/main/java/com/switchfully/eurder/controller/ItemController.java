package com.switchfully.eurder.controller;

import com.switchfully.eurder.dto.itemDto.CreateItemDto;
import com.switchfully.eurder.dto.itemDto.ItemDto;
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
    private ItemService itemService;
    private AdminService adminService;

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
    public ItemDto getItem(@PathVariable Long id) {
        return itemService.finById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ItemDto> getItems() {
        return itemService.findAllItems();
    }


}
