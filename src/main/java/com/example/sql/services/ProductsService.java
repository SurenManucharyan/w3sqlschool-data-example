package com.example.sql.services;

import com.example.sql.model.dto.ProductsCreate;
import com.example.sql.model.entity.Products;
import org.springframework.stereotype.Service;

@Service
public interface ProductsService extends CommonService<Products> {
    Products saveProducts(Products products, ProductsCreate productsCreate);
    Products newProduct(ProductsCreate productsCreate);
}
