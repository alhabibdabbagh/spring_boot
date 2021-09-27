package com.example.demo.dao;

import com.example.demo.model.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Objects;

/**
 * @author Habib
 * @on 9/25/21 - 8:12 PM
 */

@Repository
public class EmployeeDAOHiberImpl implements EmployeeDAO<Employee> {
    private EntityManager entityManager;

    public EmployeeDAOHiberImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        return entityManager.createQuery("select e from Employee e ", Employee.class).getResultList();
    }

    @Override
    public Employee findById(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    @Transactional
    public String save(Employee object) {
        Employee e = entityManager.merge(object);
        return e.getFullName();
    }

    @Override
    @Transactional
    public void deleteById(int id) {
    Employee e =entityManager.find(Employee.class,id);
    entityManager.remove(e);
    }

    @Override
    @Transactional
    public Employee updateEmployee(Employee employee) {
        Employee e = entityManager.find(Employee.class, employee.getId());
        return entityManager.merge(employee);
    }
}
