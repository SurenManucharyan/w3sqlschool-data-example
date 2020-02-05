package com.example.sql.services;

import com.example.sql.model.dto.OrderDetailsCreate;
import com.example.sql.model.dto.OrdersCreate;
import com.example.sql.model.entity.OrderDetails;
import org.springframework.stereotype.Service;

@Service
public interface OrderDetailsService extends CommonService<OrderDetails> {
    OrderDetails saveOrderDetails(OrderDetails orderDetails, OrderDetailsCreate orderDetailsCreate);

    OrderDetails newOrderDetails(OrderDetailsCreate orderDetailsCreate);
}
