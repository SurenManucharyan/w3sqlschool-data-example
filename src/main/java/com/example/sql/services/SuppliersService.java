package com.example.sql.services;

import com.example.sql.model.dto.SuppliersCreate;
import com.example.sql.model.entity.Suppliers;
import org.springframework.stereotype.Service;

@Service
public interface SuppliersService extends CommonService<Suppliers> {
    Suppliers saveSuppliers(Suppliers suppliers, SuppliersCreate suppliersCreate);
}
