package com.ahmedaatif.employees.repository;

import java.io.IOException;
import java.util.List;

import com.ahmedaatif.employees.dto.EmployeeCreationDto;
import com.ahmedaatif.employees.model.Employee;

public interface EmployeeRepository {
    EmployeeCreationDto addEmployee(Employee employee) throws IOException;

    List<Employee> getEmployees() throws IOException;
}
