package com.example.demo.dao;


import com.example.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * @author Habib
 * @on 9/24/21 - 8:54 AM
 */
@Repository
public class EmployeeDAOJPAImpl implements EmployeeDAO<Employee> {

    private EntityManager entityManager;


    public EmployeeDAOJPAImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        // return null;
        return entityManager.createQuery(" select  e from Employee  e", Employee.class).getResultList(); //TODO
    }

    @Override
    public Employee findById(int id) {
       Employee e = entityManager.find(Employee.class,id);
       // Employee e = entityManager.createQuery("select  w from Employee w where w.id=?id",Employee.class).getSingleResult();
       return e;
    }

    @Override
    @Transactional
    public String save(Employee object) {
        Employee e =entityManager.merge(object);
     //   int e = entityManager.createQuery("select e.id from Employee e ", Integer.class).getSingleResult();
        return e.getFullName();
    }

    @Override
    public void deleteById(int id) {

    }
}
