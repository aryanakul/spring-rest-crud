package com.spring.rest.crud.item.controllers;

import com.spring.rest.crud.item.payloads.ItemDto;
import com.spring.rest.crud.item.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.learn.blog.payloads.ApiResponse;

import java.util.List;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    // get all items
    @GetMapping
    public ResponseEntity<List<ItemDto>> getItems() {
        return new ResponseEntity<List<ItemDto>>(this.itemService.getItems(), HttpStatus.OK);
    }

    // get items by id
    @GetMapping(path = "/{id}")
    public ResponseEntity<ItemDto> getItem(@PathVariable Integer id) {
        return new ResponseEntity<ItemDto>(this.itemService.getItem(id), HttpStatus.OK);
    }

    // create item
    @PostMapping(consumes = "application/json")
    public ResponseEntity<ItemDto> createItem(@Valid @RequestBody ItemDto itemDto) {
        return new ResponseEntity<ItemDto>(this.itemService.createItem(itemDto), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}", consumes = "application/json")
    public ResponseEntity<ItemDto> updateItem(@Valid @RequestBody ItemDto itemDto,
                                              @PathVariable Integer id) {
        return new ResponseEntity<ItemDto>(this.itemService.updateItem(itemDto, id), HttpStatus.OK);
    }

    // delete
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ApiResponse> deleteItem(@PathVariable Integer id) {
        this.itemService.deleteItem(id);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Item Deleted Successfully", true),HttpStatus.OK);
    }
}
