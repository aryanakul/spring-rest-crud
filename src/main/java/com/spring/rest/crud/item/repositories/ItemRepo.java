package com.spring.rest.crud.item.repositories;

import com.spring.rest.crud.item.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepo extends JpaRepository<Item, Integer> {
}
