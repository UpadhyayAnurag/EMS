package com.project.ems.controller;

import com.project.ems.entity.Employee;
import com.project.ems.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;

    // LIST OF ALL EMPLOYEES
    @GetMapping("/employees/list")
    public String getRecords(Model model){
        List<Employee> lst = employeeService.findAll();
        model.addAttribute("employees",lst);
        return "employee_lst";
    }

    // FETCH EMPLOYEE BY ID
    @GetMapping("/employees/{id}")
    public Employee getRecordById(@PathVariable("id") Integer id){
        return employeeService.empById(id);
    }

    // SHOW FORM FOR ADD
    @GetMapping("/employees/register")
    public String showFormForAdd(Model model){
        model.addAttribute("employee",new Employee());
        return "employee_form";
    }

    // ADD EMPLOYEE
    @PostMapping("/employees/save")
    public String addRecord(@ModelAttribute("employee") Employee theEmployee){
        employeeService.save(theEmployee);
        return "redirect:/employees/list";
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
