package com.example.demo.controller;


import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Habib
 * @on 9/24/21 - 8:41 AM
 */
@RestController
@RequestMapping("/api")
public class EmployeeController {

    private EmployeeService employeeService;


    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> findAll(){
        return new ResponseEntity<List<Employee>>(employeeService.findAll(), HttpStatus.OK);
    }
    @PostMapping("/employees")
    public String saveEmployee(@RequestBody Employee employee){

     return employeeService.save(employee);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> findById(@PathVariable int id){
        return new  ResponseEntity<>(employeeService.findById(id),HttpStatus.OK);
    }
}