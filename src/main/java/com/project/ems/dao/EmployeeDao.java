package com.project.ems.dao;

import com.project.ems.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> findAll();
    Employee empById(Integer id);
    Employee save(Employee theEmployee);
    void deleteById(Integer id);

}
