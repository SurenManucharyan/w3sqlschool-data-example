package com.example.sql.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerCreate {
    private String customerName;
    private String contactName;
    private String address;
    private String city;
    private String postalCode;
    private String country;
}

