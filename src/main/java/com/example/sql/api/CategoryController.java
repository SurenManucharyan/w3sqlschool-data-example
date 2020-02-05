package com.example.sql.api;

import com.example.sql.model.dto.CategoryCreate;
import com.example.sql.model.entity.Category;
import com.example.sql.services.CategoryService;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/addCategory")
    public Iterable<Category> addUserInfo(@RequestBody CategoryCreate categoryCreate) {
        Category category = new Category();
        categoryService.saveCategory(category, categoryCreate);
        return categoryService.listAll();
    }

    @PutMapping("/editCategory")
    public Iterable<Category> editUserInfo(@RequestBody CategoryCreate categoryCreate, @RequestParam("categoryId") int categoryId) {
        Category category = categoryService.getById(categoryId);
        categoryService.saveCategory(category, categoryCreate);
        return categoryService.listAll();
    }

    @DeleteMapping("/deleteCategory")
    public Iterable<Category> deleteUserInfoById(@RequestParam("categoryId") int categoryId) {
        categoryService.remove(categoryService.getById(categoryId));
        return categoryService.listAll();
    }

    @GetMapping("/getAllCategories")
    public Iterable<Category> getAllCategories() {
        return categoryService.listAll();
    }

    @GetMapping("/getCategoryById")
    public Category getInfoById(@RequestParam("categoryId") int categoryId) {
        return categoryService.getById(categoryId);
    }
}
