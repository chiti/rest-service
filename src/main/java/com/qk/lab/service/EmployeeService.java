package com.qk.lab.service;

import com.qk.lab.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getEmployees();
    Employee getEmployee(Long id);

    Employee createEmployee(Employee employee);

    boolean updateEmployee(Long id,Employee employee);

    //boolean deleteEmployee(long id);
}
