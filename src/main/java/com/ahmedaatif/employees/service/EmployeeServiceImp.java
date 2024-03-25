package com.ahmedaatif.employees.service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<Employee> getAllEmployees(String name, String fromSalary, String toSalary) throws IOException {
        List<Employee> employees = employeeRepository.getEmployees();

        if (name == null && fromSalary == null && toSalary == null) {
            return employees;
        } else {
            List<Employee> filtered = employees.stream()
                    .filter(employee -> (name != null
                            && (employee.firstName.contains(name) || employee.lastName.contains(name))) || name == null)
                    .filter(employee -> (fromSalary != null
                            && (Integer.parseInt(fromSalary) <= Integer.parseInt(employee.salary)))
                            || fromSalary == null)
                    .filter(employee -> (toSalary != null
                            && (Integer.parseInt(employee.salary) <= Integer.parseInt(toSalary)) || toSalary == null))
                    .collect(Collectors.toList());

            return filtered;
        }

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
