package com.example.sql.api;

import com.example.sql.model.dto.ProductsCreate;
import com.example.sql.model.entity.Products;
import com.example.sql.services.CategoryService;
import com.example.sql.services.ProductsService;
import com.example.sql.services.SuppliersService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductsController {
    private final ProductsService productsService;
    private final SuppliersService suppliersService;
    private final CategoryService categoryService;

    public ProductsController(ProductsService productsService, SuppliersService suppliersService, CategoryService categoryService) {
        this.productsService = productsService;
        this.suppliersService = suppliersService;
        this.categoryService = categoryService;
    }

    @PostMapping("/addProduct")
    public Iterable<Products> addProduct(@RequestBody ProductsCreate productsCreate) {
        productsService.newProduct(productsCreate);
        return productsService.listAll();
    }

    @PutMapping("/editProduct")
    public Iterable<Products> editProduct(@RequestBody ProductsCreate productsCreate, @RequestParam("productId") int productId) {
        Products products = productsService.getById(productId);
        productsService.saveProducts(products, productsCreate);
        return productsService.listAll();
    }

    @DeleteMapping("/deleteProduct")
    public Iterable<Products> deleteProduct(@RequestParam("productId") int productId) {
        productsService.remove(productsService.getById(productId));
        return productsService.listAll();
    }

    @GetMapping("/getAllProducts")
    public Iterable<Products> getAllProducts() {
        return productsService.listAll();
    }

    @GetMapping("/getProductById")
    public Products getProductById(@RequestParam("productId") int productId) {
        return productsService.getById(productId);
    }
}
