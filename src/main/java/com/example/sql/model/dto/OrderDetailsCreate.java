package com.example.sql.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetailsCreate {
    private Integer quantity;
    private Integer productId;
    private Integer ordersId;
}
