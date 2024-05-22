package com.example.springbootjwt.serviceimpl;

import com.example.springbootjwt.entities.ItemCategory;
import com.example.springbootjwt.repo.ItemCategoryRepository;
import com.example.springbootjwt.services.ItemCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemCategoryServiceImpl implements ItemCategoryService {

    private final ItemCategoryRepository itemCategoryRepository;

    @Autowired
    public ItemCategoryServiceImpl(ItemCategoryRepository itemCategoryRepository) {
        this.itemCategoryRepository = itemCategoryRepository;
    }

    @Override
    public ItemCategory saveItemCategory(ItemCategory itemCategory) {
        return itemCategoryRepository.save(itemCategory);
    }

    @Override
    public ItemCategory updateItemCategory(Long id, ItemCategory itemCategory) {
        Optional<ItemCategory> existingItemCategory = itemCategoryRepository.findById(id);
        if (existingItemCategory.isPresent()) {
            ItemCategory updatedItemCategory = existingItemCategory.get();
            updatedItemCategory.setName(itemCategory.getName());
            return itemCategoryRepository.save(updatedItemCategory);
        } else {
            // Handle case where item category is not found
            return null;
        }
    }

    @Override
    public void deleteItemCategory(Long id) {
        itemCategoryRepository.deleteById(id);
    }

    @Override
    public Optional<ItemCategory> getItemCategoryById(Long id) {
        return itemCategoryRepository.findById(id);
    }

    @Override
    public List<ItemCategory> getAllItemCategories() {
        return itemCategoryRepository.findAll();
    }
}
