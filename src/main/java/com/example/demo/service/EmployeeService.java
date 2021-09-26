package com.example.demo.service;


import com.example.demo.dao.EmployeeDAO;
import com.example.demo.dao.EmployeeDAOJPAImpl;
import com.example.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Habib
 * @on 9/24/21 - 8:42 AM
 */
@Service
public class EmployeeService implements BaseService<Employee> {

private EmployeeDAO employeeDAOJPA;

@Autowired
    public EmployeeService(@Qualifier("employeeDAOHiberImpl") EmployeeDAO employeeDAOJPA) {
        this.employeeDAOJPA = employeeDAOJPA;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAOJPA.findAll();
    }

    @Override
    public Employee findById(int id) {
        return (Employee) employeeDAOJPA.findById(id);
    }

    @Override
    public String save(Employee object) {
   return employeeDAOJPA.save(object);
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return (Employee) employeeDAOJPA.updateEmployee(employee);
    }
}
