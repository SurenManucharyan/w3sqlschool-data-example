package com.example.sql.services;

import com.example.sql.model.dto.CustomerCreate;
import com.example.sql.model.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService extends CommonService<Customer> {
    Customer saveCustomer(Customer customer, CustomerCreate customerCreate);
}
