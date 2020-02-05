package com.example.sql.services;

import com.example.sql.model.dto.EmployeeCreate;
import com.example.sql.model.entity.Employee;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService extends CommonService<Employee> {
    Employee saveEmployee(Employee employee, EmployeeCreate employeeCreate);
}
