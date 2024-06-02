package com.example.demo.service;


import com.example.demo.Entity.MenuCategory;
import com.example.demo.repository.MenuCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuCategoryService {
    @Autowired
    private MenuCategoryRepository menuCategoryRepository;

    public MenuCategory saveMenuCategory(MenuCategory menuCategory) {
        return menuCategoryRepository.save(menuCategory);
    }

    public List<MenuCategory> getAllMenuCategories() {
        return menuCategoryRepository.findAll();
    }
}
