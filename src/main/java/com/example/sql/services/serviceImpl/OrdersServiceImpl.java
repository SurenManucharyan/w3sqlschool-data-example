package com.example.sql.services.serviceImpl;

import com.example.sql.model.dto.OrdersCreate;
import com.example.sql.model.entity.*;
import com.example.sql.repositories.OrdersRepository;
import com.example.sql.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersServiceImpl extends BaseService<Orders, OrdersRepository> implements OrdersService {
    @Lazy
    public CustomerService customerService;
    @Lazy
    public EmployeeService employeeService;
    @Lazy
    public ProductsService productsService;
    @Lazy
    public ShippersService shippersService;

    @Autowired
    public OrdersServiceImpl(OrdersRepository repository, CustomerService customerService, EmployeeService employeeService,
                             ProductsService productsService, ShippersService shippersService) {
        super(repository);
        this.customerService = customerService;
        this.employeeService = employeeService;
        this.productsService = productsService;
        this.shippersService = shippersService;

    }

    @Override
    public Orders saveOrders(Orders orders, OrdersCreate ordersCreate) {
        orders.setOrderDate(ordersCreate.getOrderDate());
        return save(orders);
    }

    @Override
    public Orders newOrders(OrdersCreate ordersCreate) {
        Customer customer = customerService.getById(ordersCreate.getCustomerId());
        Employee employee = employeeService.getById(ordersCreate.getEmployeeId());
        Shippers shippers = shippersService.getById(ordersCreate.getShipperId());

        List<OrderDetails> orderDetails = new ArrayList<>();
        ordersCreate.getOrderDetailDto().forEach(orderDetailDto -> {
            Products product = productsService.getById(orderDetailDto.getProductId());
            OrderDetails orderDetails1 = new OrderDetails();
            orderDetails1.setQuantity(orderDetailDto.getQuantity());
            orderDetails1.setProduct(product);
            orderDetails.add(orderDetails1);
        });

        Orders order = new Orders();
        order.setOrderDetails(orderDetails);
        order.setCustomer(customer);
        order.setEmployee(employee);
        order.setShippers(shippers);
        order.setOrderDate(ordersCreate.getOrderDate());

        return save(order);
    }
}
