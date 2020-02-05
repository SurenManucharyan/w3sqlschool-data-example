package com.example.sql.api;

import com.example.sql.model.dto.SuppliersCreate;
import com.example.sql.model.entity.Suppliers;
import com.example.sql.services.SuppliersService;
import org.springframework.web.bind.annotation.*;

@RestController
public class SuppliersController {
    private final SuppliersService suppliersService;

    public SuppliersController(SuppliersService suppliersService) {
        this.suppliersService = suppliersService;
    }

    @PostMapping("/addSupplier")
    public Iterable<Suppliers> addSupplier(@RequestBody SuppliersCreate suppliersCreate) {
        Suppliers suppliers = new Suppliers();
        suppliersService.saveSuppliers(suppliers, suppliersCreate);
        return suppliersService.listAll();
    }

    @PutMapping("/editSupplier")
    public Iterable<Suppliers> editSupplier(@RequestBody SuppliersCreate suppliersCreate, @RequestParam("supplierId") int supplierId) {
        Suppliers suppliers = suppliersService.getById(supplierId);
        suppliersService.saveSuppliers(suppliers, suppliersCreate);
        return suppliersService.listAll();
    }

    @DeleteMapping("/deleteSupplier")
    public Iterable<Suppliers> deleteSupplier(@RequestParam("supplierId") int supplierId) {
        suppliersService.remove(suppliersService.getById(supplierId));
        return suppliersService.listAll();
    }

    @GetMapping("/getAllSuppliers")
    public Iterable<Suppliers> getAllSuppliers() {
        return suppliersService.listAll();
    }

    @GetMapping("/getSupplierById")
    public Suppliers getSupplierById(@RequestParam("supplierId") int supplierId) {
        return suppliersService.getById(supplierId);
    }
}
