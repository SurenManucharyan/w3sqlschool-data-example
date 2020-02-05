package com.example.sql.services.serviceImpl;

import com.example.sql.model.dto.ShippersCreate;
import com.example.sql.model.entity.Shippers;
import com.example.sql.repositories.ShippersRepository;
import com.example.sql.services.BaseService;
import com.example.sql.services.ShippersService;
import org.springframework.stereotype.Service;

@Service
public class ShippersServiceImpl extends BaseService<Shippers, ShippersRepository> implements ShippersService {
    public ShippersServiceImpl(ShippersRepository repository) {
        super(repository);
    }

    @Override
    public Shippers saveShippers(Shippers shippers, ShippersCreate shippersCreate) {
        shippers.setShipperName(shippersCreate.getShipperName());
        shippers.setPhone(shippersCreate.getPhone());
        return save(shippers);
    }
}
