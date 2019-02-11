package com.qk.lab.service;

import com.qk.lab.model.Employee;
import com.qk.lab.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getEmployees() {
        return (ArrayList<Employee>) employeeRepository.findAll();
    }


    @Override
    public Employee getEmployee(Long id) {

        Optional<Employee> employee = employeeRepository.findById(id);
         return employee.get();


    }

    @Override
    public Employee createEmployee(Employee employee) {
        Employee savedEmployee = employeeRepository.save(employee);

        if(savedEmployee != null){
            return savedEmployee;

        }
        return null;
    }


    @Override
    public boolean updateEmployee(Long id, Employee employee) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
         Employee savedEmployee = optionalEmployee.get();

        if(savedEmployee == null)
            return false;


            savedEmployee.setFirstName(employee.getFirstName());
            savedEmployee.setLastName(employee.getLastName());
            employeeRepository.save(savedEmployee);
            return true;



    }




}
