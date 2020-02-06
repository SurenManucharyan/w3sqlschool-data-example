package com.example.sql.api;

import com.example.sql.model.dto.ProductsCreate;
import com.example.sql.model.entity.Products;
import com.example.sql.services.CategoryService;
import com.example.sql.services.ProductsService;
import com.example.sql.services.SuppliersService;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

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

    @GetMapping("/getBestSellers")
    public void getBestSellers() throws Exception {

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/w3sql_example");
        Statement statement = conn.createStatement();
        String sql = "SELECT  order_details.id,quantity,products.id,products.product_name,products.price  " +
                "FROM order_details  left JOIN products ON order_details.product_id = products.id " +
                "Order by  quantity desc;";
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            System.out.println(resultSet.getInt("order_details.id"));
            System.out.println(resultSet.getInt("quantity"));
            System.out.println(resultSet.getInt("products.id"));
            System.out.println(resultSet.getString("product_name"));
            System.out.println(resultSet.getDouble("price"));
        }
    }
}

