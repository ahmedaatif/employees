package com.ahmedaatif.employees.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ahmedaatif.employees.convert.EmployeeDtoConverter;
import com.ahmedaatif.employees.dto.EmployeeCreationDto;
import com.ahmedaatif.employees.dto.EmployeeDto;
import com.ahmedaatif.employees.model.Employee;
import com.ahmedaatif.employees.repository.EmployeeRepositoryImp;

@Component
public class EmployeeServiceImp implements EmployeeService {
    private final EmployeeRepositoryImp employeeRepository;

    private final EmployeeDtoConverter employeeDtoConverter;

    public EmployeeServiceImp(EmployeeRepositoryImp employeeRepository, EmployeeDtoConverter employeeDtoConverter) {
        super();
        this.employeeRepository = employeeRepository;
        this.employeeDtoConverter = employeeDtoConverter;
    }

    @Override
    public List<Employee> getAllEmployees() throws IOException {
        return employeeRepository.getEmployees();
    }

    @Override
    public Employee getEmployee(int id) throws IOException {
        return employeeRepository.getEmployee(id);
    }

    @Override
    public EmployeeCreationDto addEmployee(EmployeeDto employee) throws IOException {
        Employee employeeModel = employeeDtoConverter.convertEmployeeDtoToEmployee(employee);

        return employeeRepository.addEmployee(employeeModel);
    }
}
