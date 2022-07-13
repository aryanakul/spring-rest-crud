package com.spring.rest.crud.item.services;

import com.spring.rest.crud.item.payloads.ItemDto;

import java.util.List;

public interface ItemService {

    // create item
    ItemDto createItem(ItemDto itemDto);

    // update item
    ItemDto updateItem(ItemDto itemDto, Integer id);

    // get all items
    List<ItemDto> getItems();

    // get item by Id
    ItemDto getItem(Integer id);

    // delete item by Id
    void deleteItem(Integer id);
}
