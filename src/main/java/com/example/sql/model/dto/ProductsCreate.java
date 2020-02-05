package com.example.sql.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductsCreate {
    private String productName;
    private String unit;
    private double price;
    private Integer supplierId;
    private Integer categoryId;
}
