package com.example.sql.api;

import com.example.sql.model.dto.EmployeeCreate;
import com.example.sql.model.entity.Employee;
import com.example.sql.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/addEmployee")
    public Iterable<Employee> addEmployee(@RequestBody EmployeeCreate employeeCreate) {
        Employee employee = new Employee();
        employeeService.saveEmployee(employee, employeeCreate);
        return employeeService.listAll();
    }

    @PutMapping("/editEmployee")
    public Iterable<Employee> editEmployee(@RequestBody EmployeeCreate employeeCreate, @RequestParam("employeeId") int employeeId) {
        Employee employee = employeeService.getById(employeeId);
        employeeService.saveEmployee(employee, employeeCreate);
        return employeeService.listAll();
    }

    @DeleteMapping("/deleteEmployee")
    public Iterable<Employee> deleteEmployee(@RequestBody EmployeeCreate employeeCreate, @RequestParam("employeeId") int employeeId) {
        employeeService.remove(employeeService.getById(employeeId));
        return employeeService.listAll();
    }

    @GetMapping("/getAllEmployees")
    public Iterable<Employee> getAllEmployees() {
        return employeeService.listAll();
    }

    @GetMapping("/getEmployeeById")
    public Employee getEmployeeById(@RequestParam("employeeId") int employeeId) {
        return employeeService.getById(employeeId);
    }
}
