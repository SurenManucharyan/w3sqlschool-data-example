package com.example.sql.api;

import com.example.sql.model.dto.CustomerCreate;
import com.example.sql.model.entity.Customer;
import com.example.sql.services.CustomerService;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/addCustomer")
    public Iterable<Customer> addCustomer(@RequestBody CustomerCreate customerCreate) {
        Customer customer = new Customer();
        customerService.saveCustomer(customer, customerCreate);
        return customerService.listAll();
    }

    @PutMapping("/editCustomer")
    public Iterable<Customer> editCustomer(@RequestBody CustomerCreate customerCreate, @RequestParam("customerId") int customerId) {
        Customer customer = customerService.getById(customerId);
        customerService.saveCustomer(customer, customerCreate);
        return customerService.listAll();
    }

    @DeleteMapping("/deleteCustomer")
    public Iterable<Customer> deleteCustomer(@RequestParam("customerId") int customerId) {
        customerService.remove(customerService.getById(customerId));
        return customerService.listAll();
    }

    @GetMapping("/getAllCustomers")
    public Iterable<Customer> getAllCustomers() {
        return customerService.listAll();
    }

    @GetMapping("/getCustomerById")
    public Customer getCustomerById(@RequestParam("customerId") int customerId) {
        return customerService.getById(customerId);
    }
}