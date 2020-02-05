package com.example.sql.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Employee extends BaseEntity {
    private String lastName;
    private String firstName;
    private Date birthDate;
    private String photo;
    private String notes;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "employee")
    private List<Orders> orders;
}
