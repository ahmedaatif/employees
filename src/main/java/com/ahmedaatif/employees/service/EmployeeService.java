package com.ahmedaatif.employees.service;

import java.io.IOException;
import java.util.List;

import com.ahmedaatif.employees.dto.EmployeeCreationDto;
import com.ahmedaatif.employees.dto.EmployeeDto;
import com.ahmedaatif.employees.model.Employee;

public interface EmployeeService {
    List<Employee> getAllEmployees(String name, String fromSalary, String toSalary) throws IOException;

    Employee getEmployee(int id) throws IOException;

    public EmployeeCreationDto addEmployee(EmployeeDto employee) throws IOException;
}
