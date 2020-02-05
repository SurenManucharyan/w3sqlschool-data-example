package com.example.sql.services.serviceImpl;

import com.example.sql.model.dto.EmployeeCreate;
import com.example.sql.model.entity.Employee;
import com.example.sql.repositories.EmployeeRepository;
import com.example.sql.services.BaseService;
import com.example.sql.services.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends BaseService<Employee, EmployeeRepository> implements EmployeeService {
    public EmployeeServiceImpl(EmployeeRepository repository) {
        super(repository);
    }

    @Override
    public Employee saveEmployee(Employee employee, EmployeeCreate employeeCreate) {
        employee.setLastName(employeeCreate.getLastName());
        employee.setFirstName(employeeCreate.getFirstName());
        employee.setBirthDate(employeeCreate.getBirthDate());
        employee.setPhoto(employeeCreate.getPhoto());
        employee.setNotes(employeeCreate.getNotes());
        return save(employee);
    }
}
