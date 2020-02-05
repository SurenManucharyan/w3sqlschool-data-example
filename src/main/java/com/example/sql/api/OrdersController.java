package com.example.sql.api;

import com.example.sql.model.dto.OrdersCreate;
import com.example.sql.model.entity.Orders;
import com.example.sql.services.CustomerService;
import com.example.sql.services.EmployeeService;
import com.example.sql.services.OrdersService;
import com.example.sql.services.ShippersService;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrdersController {
    private final OrdersService ordersService;
    private final CustomerService customerService;
    private final EmployeeService employeeService;
    private final ShippersService shippersService;

    public OrdersController(OrdersService ordersService, CustomerService customerService, EmployeeService employeeService, ShippersService shippersService) {
        this.ordersService = ordersService;
        this.customerService = customerService;
        this.employeeService = employeeService;
        this.shippersService = shippersService;
    }

    @PostMapping("/addOrder")
    public Iterable<Orders> addOrder(@RequestBody OrdersCreate ordersCreate) {
        ordersService.newOrders(ordersCreate);
        return ordersService.listAll();
    }

    @PutMapping("/editOrder")
    public Iterable<Orders> editOrder(@RequestBody OrdersCreate ordersCreate, @RequestParam("orderId") int orderId) {
        Orders orders = ordersService.getById(orderId);
        ordersService.newOrders(ordersCreate);
        return ordersService.listAll();
    }

    @DeleteMapping("/deleteOrder")
    public Iterable<Orders> deleteOrder(@RequestParam("orderId") int orderId) {
        ordersService.remove(ordersService.getById(orderId));
        return ordersService.listAll();
    }

    @GetMapping("/getAllOrders")
    public Iterable<Orders> getAllOrders() {
        return ordersService.listAll();
    }

    @GetMapping("/getOrderById")
    public Orders getOrderById(@RequestParam("orderId") int orderId) {
        return ordersService.getById(orderId);
    }
}
