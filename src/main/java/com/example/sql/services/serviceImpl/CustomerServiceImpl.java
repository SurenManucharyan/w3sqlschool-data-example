package com.example.sql.services.serviceImpl;


import com.example.sql.model.dto.CustomerCreate;
import com.example.sql.model.entity.Customer;
import com.example.sql.repositories.CustomerRepository;
import com.example.sql.services.BaseService;
import com.example.sql.services.CustomerService;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl extends BaseService<Customer, CustomerRepository> implements CustomerService {

    public CustomerServiceImpl(CustomerRepository repository) {
        super(repository);
    }

    @Override
    public Customer saveCustomer(Customer customer, CustomerCreate customerCreate) {

        customer.setCustomerName(customerCreate.getCustomerName());
        customer.setContactName(customerCreate.getContactName());
        customer.setAddress(customerCreate.getAddress());
        customer.setCity(customerCreate.getCity());
        customer.setPostalCode(customerCreate.getPostalCode());
        customer.setCountry(customerCreate.getCountry());

        return save(customer);
    }
}