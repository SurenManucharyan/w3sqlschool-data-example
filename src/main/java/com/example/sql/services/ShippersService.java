package com.example.sql.services;

import com.example.sql.model.dto.ShippersCreate;
import com.example.sql.model.entity.Shippers;
import org.springframework.stereotype.Service;

@Service
public interface ShippersService extends CommonService<Shippers> {
    Shippers saveShippers(Shippers shippers, ShippersCreate shippersCreate);
}
