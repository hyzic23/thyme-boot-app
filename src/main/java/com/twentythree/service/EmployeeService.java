package com.twentythree.service;

import com.twentythree.model.Employee;

import java.util.List;

//@Component
public interface EmployeeService {

    List<Employee> getAllEmployeees();
    void saveEmployee(Employee employee);
    Employee getEmployeeById(long id);
    void deleteEmployeeById(long id);
}
