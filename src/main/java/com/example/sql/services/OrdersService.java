package com.example.sql.services;

import com.example.sql.model.dto.OrdersCreate;
import com.example.sql.model.entity.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrdersService extends CommonService<Orders> {
    Orders saveOrders(Orders orders, OrdersCreate ordersCreate);

    Orders newOrders(OrdersCreate ordersCreate);
}
