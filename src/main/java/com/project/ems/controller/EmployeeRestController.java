package com.project.ems.controller;

import com.project.ems.entity.Employee;
import com.project.ems.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;

    // LIST OF ALL EMPLOYEES
    @GetMapping("/employees")
    public List<Employee> getRecords(){
        return employeeService.findAll();
    }

    // FETCH EMPLOYEE BY ID
    @GetMapping("/employees/{id}")
    public Employee getRecordById(@PathVariable("id") Integer id){
        return employeeService.empById(id);
    }

    // ADD EMPLOYEE
    @PostMapping("/employees")
    public String addRecord(@RequestBody Employee theEmployee){
        employeeService.save(theEmployee);
        return "Record Added Successfully";
    }

    // UPDATE EMPLOYEE RECORD
    @PutMapping("/employees")
    public Employee updateRecord(@RequestBody Employee theEmployee){
        return employeeService.save(theEmployee);
    }

    // DELETE RECORD
    @DeleteMapping("/employees/{id}")
    public String deleteRecord(@PathVariable("id") Integer id){
        return employeeService.deleteById(id);
    }
}
