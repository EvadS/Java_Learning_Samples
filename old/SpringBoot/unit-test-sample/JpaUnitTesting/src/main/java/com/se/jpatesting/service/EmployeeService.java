package com.se.jpatesting.service;

import com.se.jpatesting.entity.Employee;

import java.util.List;

public interface EmployeeService {
     public Employee getEmployeeById(Long id);

     public Employee getEmployeeByName(String name);

     public List<Employee> getAllEmployees();

     public boolean exists(String email);

     public Employee save(Employee employee);
}