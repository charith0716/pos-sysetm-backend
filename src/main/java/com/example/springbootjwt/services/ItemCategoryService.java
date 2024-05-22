package com.example.springbootjwt.services;

import com.example.springbootjwt.entities.ItemCategory;

import java.util.List;
import java.util.Optional;

public interface ItemCategoryService {
    ItemCategory saveItemCategory(ItemCategory itemCategory);
    ItemCategory updateItemCategory(Long id, ItemCategory itemCategory);
    void deleteItemCategory(Long id);
    Optional<ItemCategory> getItemCategoryById(Long id);
    List<ItemCategory> getAllItemCategories();
}
