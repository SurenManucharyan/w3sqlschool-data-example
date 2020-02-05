package com.example.sql.api;

import com.example.sql.model.dto.ShippersCreate;
import com.example.sql.model.entity.Shippers;
import com.example.sql.services.ShippersService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShippersController {
    private final ShippersService shippersService;


    public ShippersController(ShippersService shippersService) {
        this.shippersService = shippersService;
    }

    @PostMapping("/addShipper")
    public Iterable<Shippers> addShipper(@RequestBody ShippersCreate shippersCreate){
        Shippers shippers = new Shippers();
        shippersService.saveShippers(shippers,shippersCreate);
        return shippersService.listAll();
    }

    @PutMapping("/editShipper")
    public Iterable<Shippers> editShipper(@RequestBody ShippersCreate shippersCreate, @RequestParam("shipperId") int shipperId){
        Shippers shippers = shippersService.getById(shipperId);
        shippersService.saveShippers(shippers,shippersCreate);
        return shippersService.listAll();
    }

    @DeleteMapping("/deleteShipper")
    public Iterable<Shippers> deleteShipper(@RequestParam("shipperId") int shipperId){
        shippersService.remove(shippersService.getById(shipperId));
        return shippersService.listAll();
    }

    @GetMapping("/getAllShippers")
    public Iterable<Shippers> getAllShippers(){
        return shippersService.listAll();
    }

    @GetMapping("/getShipperById")
    public Shippers getShipperById(@RequestParam("shipperId") int shipperId){
        return shippersService.getById(shipperId);
    }
}
