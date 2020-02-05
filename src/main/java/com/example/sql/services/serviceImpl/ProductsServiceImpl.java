package com.example.sql.services.serviceImpl;

import com.example.sql.model.dto.ProductsCreate;
import com.example.sql.model.entity.Category;
import com.example.sql.model.entity.Products;
import com.example.sql.model.entity.Suppliers;
import com.example.sql.repositories.ProductsRepository;
import com.example.sql.services.BaseService;
import com.example.sql.services.CategoryService;
import com.example.sql.services.ProductsService;
import com.example.sql.services.SuppliersService;
import org.springframework.stereotype.Service;

@Service
public class ProductsServiceImpl extends BaseService<Products, ProductsRepository> implements ProductsService {
    public SuppliersService suppliersService;
    public CategoryService categoryService;

    public ProductsServiceImpl(ProductsRepository repository) {
        super(repository);
    }

    @Override
    public Products saveProducts(Products products, ProductsCreate productsCreate) {
        products.setProductName(productsCreate.getProductName());
        products.setUnit(productsCreate.getUnit());
        products.setPrice(productsCreate.getPrice());
        return save(products);
    }

    @Override
    public Products newProduct(ProductsCreate productsCreate) {
        Suppliers supplier = suppliersService.getById(productsCreate.getSupplierId());
        Category category = categoryService.getById(productsCreate.getCategoryId());

        Products product = new Products();
        product.setProductName(productsCreate.getProductName());
        product.setUnit(productsCreate.getUnit());
        product.setPrice(productsCreate.getPrice());
        product.setSuppliers(supplier);
        product.setCategory(category);
        return save(product);
    }
}
