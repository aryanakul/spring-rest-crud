package com.spring.rest.crud.item.services.impl;

import com.spring.rest.crud.item.entities.Item;
import com.spring.rest.crud.item.exceptions.ResourceNotFoundException;
import com.spring.rest.crud.item.payloads.ItemDto;
import com.spring.rest.crud.item.repositories.ItemRepo;
import com.spring.rest.crud.item.services.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ItemDto createItem(ItemDto itemDto) {
        Item savedItem = this.itemRepo.save(dtoToItem(itemDto));
        return this.itemToDto(savedItem);
    }

    @Override
    public ItemDto updateItem(ItemDto itemDto, Integer id) {
        Item item = this.itemRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Item", "Id", id));
        item.setDesc(itemDto.getDesc());
        item.setName(itemDto.getName());
        return this.itemToDto(this.itemRepo.save(item));
    }

    @Override
    public List<ItemDto> getItems() {
        List<Item> items = this.itemRepo.findAll();
        return items.stream().map((item -> this.itemToDto(item))).collect(Collectors.toList());
    }

    @Override
    public ItemDto getItem(Integer id) {
        Item item = this.itemRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Item", "Id", id));
        return this.itemToDto(item);
    }

    @Override
    public void deleteItem(Integer id) {
        Item item = this.itemRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Item", "Id", id));
        this.itemRepo.delete(item);
    }

    private ItemDto itemToDto(Item item) {
        return this.modelMapper.map(item, ItemDto.class);
    }

    private Item dtoToItem(ItemDto itemDto) {
        return this.modelMapper.map(itemDto, Item.class);
    }
}
