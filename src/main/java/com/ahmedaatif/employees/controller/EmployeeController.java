package com.ahmedaatif.employees.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahmedaatif.employees.dto.EmployeeCreationDto;
import com.ahmedaatif.employees.dto.EmployeeDto;
import com.ahmedaatif.employees.model.Employee;
import com.ahmedaatif.employees.service.EmployeeService;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }

    @RequestMapping
    public List<Employee> getEmployees() throws IOException {
        return this.employeeService.getAllEmployees();
    }

    @RequestMapping("/{id}")
    public Employee getEmployees(@PathVariable int id) throws IOException {
        return this.employeeService.getEmployee(id);
    }

    @PostMapping
    public EmployeeCreationDto addEmployee(@RequestBody EmployeeDto employee) throws IOException {
        return this.employeeService.addEmployee(employee);
    }

}
