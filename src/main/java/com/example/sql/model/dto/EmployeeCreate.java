package com.example.sql.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class EmployeeCreate {
    private String lastName;
    private String firstName;
    private Date birthDate;
    private String photo;
    private String notes;
}
