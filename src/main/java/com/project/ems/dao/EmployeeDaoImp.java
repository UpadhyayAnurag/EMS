package com.project.ems.dao;

import com.project.ems.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImp implements EmployeeDao{

    @Autowired
    private EntityManager entityManager;
    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createQuery("from Employee",Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee empById(Integer id) {
        return entityManager.find(Employee.class,id);
    }

    @Override
    public Employee save(Employee theEmployee) {
        Employee record = entityManager.merge(theEmployee);
        return record;
    }

    @Override
    public void deleteById(Integer id) {
        Employee record = entityManager.find(Employee.class,id);
        entityManager.remove(record);
    }
}
