package com.project.ems.services;

import com.project.ems.dao.EmployeeDao;
import com.project.ems.entity.Employee;
import com.project.ems.exceptions.EmployeeNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public Employee empById(Integer id) {
        return employeeDao.empById(id);
    }

    @Override
    @Transactional
    public Employee save(Employee theEmployee) {
        return employeeDao.save(theEmployee);
    }

    @Override
    @Transactional
    public String deleteById(Integer id) {
        Employee theEmployee = employeeDao.empById(id);
        if(theEmployee == null){
            throw new EmployeeNotFoundException("Employee requested, do not exists");
        }
        else{
            employeeDao.deleteById(id);
            return "Record removed Successfully";
        }
    }
}
