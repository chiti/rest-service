package com.qk.lab.controller;

import com.qk.lab.model.Employee;
import com.qk.lab.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private EmployeeService employeeService;
    public EmployeeController() {

    }

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
       return employeeService.getEmployees();
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") long id){

        Employee employee = employeeService.getEmployee(id);

        if (employee == null) return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<Employee>(employee,HttpStatus.OK);
    }

    @PostMapping(value ="/employee",consumes="application/json" )
    public ResponseEntity<Employee> createEmployee(@RequestBody(required = true) Employee employee){

        Employee createEmployee = employeeService.createEmployee(employee);

        if (createEmployee == null) return new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);

        return new ResponseEntity<Employee>(HttpStatus.CREATED);
    }


    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id,@RequestBody Employee employee){


        if (employeeService.updateEmployee(id,employee)) return new ResponseEntity<Employee>(HttpStatus.OK);

        return new ResponseEntity<Employee>(employee,HttpStatus.NOT_FOUND);
    }

}
