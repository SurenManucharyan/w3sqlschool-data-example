package com.example.sql.api;

import com.example.sql.model.dto.OrderDetailsCreate;
import com.example.sql.model.entity.OrderDetails;
import com.example.sql.services.OrderDetailsService;
import com.example.sql.services.OrdersService;
import com.example.sql.services.ProductsService;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderDetailsController {
    private final OrderDetailsService orderDetailsService;
    private final OrdersService ordersService;
    private final ProductsService productsService;

    public OrderDetailsController(OrderDetailsService orderDetailsService, OrdersService ordersService, ProductsService productsService) {
        this.orderDetailsService = orderDetailsService;
        this.ordersService = ordersService;
        this.productsService = productsService;
    }

    @PostMapping("/addOrderDetails")
    public Iterable<OrderDetails> addOrderDetail(@RequestBody OrderDetailsCreate orderDetailsCreate) {
        orderDetailsService.newOrderDetails(orderDetailsCreate);
        return orderDetailsService.listAll();
    }

    @PutMapping("/editOrderDetails")
    public Iterable<OrderDetails> editOrderDetails(@RequestBody OrderDetailsCreate orderDetailsCreate, @RequestParam("orderDetailsId") int orderDetailsId) {
        OrderDetails orderDetails = orderDetailsService.getById(orderDetailsId);
        orderDetailsService.saveOrderDetails(orderDetails, orderDetailsCreate);
        return orderDetailsService.listAll();
    }

    @DeleteMapping("/deleteOrderDetails")
    public Iterable<OrderDetails> deleteOrderDetails(@RequestParam("orderDetailsId") int orderDetailsId) {
        orderDetailsService.remove(orderDetailsService.getById(orderDetailsId));
        return orderDetailsService.listAll();
    }

    @GetMapping("/getAllOrderDetails")
    public Iterable<OrderDetails> getAllOrderDetails() {
        return orderDetailsService.listAll();
    }

    @GetMapping("/getOrderDetailsById")
    public OrderDetails getOrderDetailsById(@RequestParam("orderDetailsId") int orderDetailsId) {
        return orderDetailsService.getById(orderDetailsId);
    }
}