package com.project.ems.services;

import com.project.ems.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee empById(Integer id);
    Employee save(Employee theEmployee);
    String deleteById(Integer id);
}
