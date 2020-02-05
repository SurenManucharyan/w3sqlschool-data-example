package com.example.sql.services;

import com.example.sql.model.dto.CategoryCreate;
import com.example.sql.model.entity.Category;
import org.springframework.stereotype.Service;

@Service
public interface CategoryService extends CommonService<Category> {
    Category saveCategory(Category category, CategoryCreate categoryCreate);
}
