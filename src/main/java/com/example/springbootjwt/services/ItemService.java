package com.example.springbootjwt.services;

import com.example.springbootjwt.entities.Item;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    Item saveItem(Item item);
    Item updateItem(Long id, Item item);
    void deleteItem(Long id);
    Optional<Item> getItemById(Long id);
    List<Item> getAllItems();
}
