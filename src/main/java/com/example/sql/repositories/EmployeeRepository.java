package com.example.sql.repositories;

import com.example.sql.model.entity.Employee;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends BaseRepository<Employee> {
}
