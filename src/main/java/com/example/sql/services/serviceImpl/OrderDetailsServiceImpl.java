package com.example.sql.services.serviceImpl;

import com.example.sql.model.dto.OrderDetailsCreate;
import com.example.sql.model.entity.OrderDetails;
import com.example.sql.model.entity.Orders;
import com.example.sql.model.entity.Products;
import com.example.sql.repositories.OrderDetailsRepository;
import com.example.sql.services.BaseService;
import com.example.sql.services.OrderDetailsService;
import com.example.sql.services.OrdersService;
import com.example.sql.services.ProductsService;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailsServiceImpl extends BaseService<OrderDetails, OrderDetailsRepository> implements OrderDetailsService {
    public ProductsService productsService;
    public OrdersService ordersService;

    public OrderDetailsServiceImpl(OrderDetailsRepository repository) {
        super(repository);
    }


    @Override
    public OrderDetails saveOrderDetails(OrderDetails orderDetails, OrderDetailsCreate orderDetailsCreate) {
        orderDetails.setQuantity(orderDetailsCreate.getQuantity());
        return save(orderDetails);
    }

    @Override
    public OrderDetails newOrderDetails(OrderDetailsCreate orderDetailsCreate) {
        Products product = productsService.getById(orderDetailsCreate.getProductId());
        Orders order = ordersService.getById(orderDetailsCreate.getOrdersId());

        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setProduct(product);
        orderDetails.setOrders(order);
        orderDetails.setQuantity(orderDetailsCreate.getQuantity());

        return save(orderDetails);
    }
}
