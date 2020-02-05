package com.example.sql.services.serviceImpl;

import com.example.sql.model.dto.SuppliersCreate;
import com.example.sql.model.entity.Suppliers;
import com.example.sql.repositories.SuppliersRepository;
import com.example.sql.services.BaseService;
import com.example.sql.services.SuppliersService;
import org.springframework.stereotype.Service;

@Service
public class SuppliersServiceImpl extends BaseService<Suppliers, SuppliersRepository> implements SuppliersService {
    public SuppliersServiceImpl(SuppliersRepository repository) {
        super(repository);
    }

    @Override
    public Suppliers saveSuppliers(Suppliers suppliers, SuppliersCreate suppliersCreate) {
        suppliers.setSupplierName(suppliersCreate.getSupplierName());
        suppliers.setContactName(suppliersCreate.getContactName());
        suppliers.setAddress(suppliersCreate.getAddress());
        suppliers.setCity(suppliersCreate.getCity());
        suppliers.setPostalCode(suppliersCreate.getPostalCode());
        suppliers.setCountry(suppliersCreate.getCountry());
        suppliers.setPhone(suppliersCreate.getPhone());
        return save(suppliers);
    }
}
