package com.example.sql.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SuppliersCreate {
    private String supplierName;
    private String contactName;
    private String address;
    private String city;
    private String postalCode;
    private String country;
    private String phone;
}
