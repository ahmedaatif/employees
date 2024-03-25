package com.ahmedaatif.employees.convert;

import org.springframework.stereotype.Component;

import com.ahmedaatif.employees.dto.EmployeeDto;
import com.ahmedaatif.employees.model.Employee;

@Component
public class EmployeeDtoConverter {

    public Employee convertEmployeeDtoToEmployee(EmployeeDto dto) {
        Employee toReturn = new Employee();

        toReturn.firstName = dto.firstName;
        toReturn.lastName = dto.lastName;
        toReturn.joinDate = dto.joinDate;
        toReturn.dateOfBirth = dto.dateOfBirth;
        toReturn.Salary = dto.Salary;
        toReturn.department = dto.department;

        return toReturn;
    }
}
