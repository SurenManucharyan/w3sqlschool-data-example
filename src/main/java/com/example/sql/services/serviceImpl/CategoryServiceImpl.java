package com.example.sql.services.serviceImpl;

import com.example.sql.model.dto.CategoryCreate;
import com.example.sql.model.entity.Category;
import com.example.sql.repositories.CategoryRepository;
import com.example.sql.services.BaseService;
import com.example.sql.services.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends BaseService<Category, CategoryRepository> implements CategoryService {

    public CategoryServiceImpl(CategoryRepository repository) {
        super(repository);
    }

    @Override
    public Category saveCategory(Category category, CategoryCreate categoryCreate) {
        category.setCategoryName(categoryCreate.getCategoryName());
        category.setDescription(categoryCreate.getDescription());
        return save(category);
    }
}