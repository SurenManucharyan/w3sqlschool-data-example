package com.example.sql.repositories;

import com.example.sql.model.entity.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends BaseRepository<Customer> {
}
