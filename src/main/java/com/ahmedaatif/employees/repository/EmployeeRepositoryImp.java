package com.ahmedaatif.employees.repository;

import java.io.IOException;
import java.util.List;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.core.io.Resource;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.ahmedaatif.employees.dto.EmployeeCreationDto;
import com.ahmedaatif.employees.model.Employee;

@Component
public class EmployeeRepositoryImp implements EmployeeRepository {
  private final ResourceLoader resourceLoader;

  public EmployeeRepositoryImp(ResourceLoader resourceLoader) {
    this.resourceLoader = resourceLoader;
  }

  public List<Employee> getEmployees() throws IOException {
    Resource resource = resourceLoader.getResource("classpath:employees.json");

    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(resource.getInputStream(), new TypeReference<List<Employee>>() {
    });
  }

  public Employee getEmployee(int id) throws IOException {
    List<Employee> employees = getEmployees();

    for (Employee employee : employees) {
      if (employee.id == id) {
        return employee;
      }
    }

    return null;
  }

  public EmployeeCreationDto addEmployee(Employee newEmployee) throws IOException {
    List<Employee> employees = getEmployees(); // Read existing employees

    newEmployee.id = getLastId() + 1;

    employees.add(newEmployee);

    ObjectMapper mapper = new ObjectMapper();

    Resource resource = resourceLoader.getResource("classpath:employees.json");

    mapper.writeValue(resource.getFile(), employees);

    EmployeeCreationDto toReturn = new EmployeeCreationDto();
    toReturn.id = newEmployee.id;

    return toReturn;
  }

  private int getLastId() throws IOException {
    List<Employee> employees = getEmployees();

    if (employees.size() > 0) {
      return employees.get(employees.size() - 1).id;
    } else {
      return 0;
    }

  }

}
