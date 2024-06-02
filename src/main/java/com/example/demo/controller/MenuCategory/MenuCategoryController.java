package com.example.demo.controller.MenuCategory;

import com.example.demo.Entity.MenuCategory;
import com.example.demo.service.MenuCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/MenuCategory")
public class MenuCategoryController {
    @Autowired
    private MenuCategoryService menuCategoryService;

    @CrossOrigin(origins = "*")
    @PostMapping("/add")
    public MenuCategory createMenuCategory(@RequestBody MenuCategory menuCategory) {
        return menuCategoryService.saveMenuCategory(menuCategory);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/get")
    public List<MenuCategory> getAllMenuCategories() {
        return menuCategoryService.getAllMenuCategories();
    }
}
