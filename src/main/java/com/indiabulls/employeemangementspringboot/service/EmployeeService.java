package com.indiabulls.employeemangementspringboot.service;

import com.indiabulls.employeemangementspringboot.model.Employee;

import java.util.List;

public interface EmployeeService {
    public void saveEmployee(Employee employee);
    public List<Employee> getEmployees();
    public Employee getEmployee(int id);
    public void deleteEmployee(int id);
    public void updateEmployee(Employee employee);

}
