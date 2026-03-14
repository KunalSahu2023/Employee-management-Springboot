package com.indiabulls.employeemangementspringboot.service;

import com.indiabulls.employeemangementspringboot.model.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee saveEmployee(Employee employee);
    public List<Employee> getEmployees();
    public Employee getEmployee(Long id);
    public void deleteEmployee(Long id);
    public Employee updateEmployee(Employee employee);

}
