package com.indiabulls.employeemangementspringboot.service;

import com.indiabulls.employeemangementspringboot.model.Employee;
import com.indiabulls.employeemangementspringboot.repository.EmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepo employeeRepo;
    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public void saveEmployee(Employee employee) {
        this.employeeRepo.save(employee);

    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee getEmployee(int id) {
        return employeeRepo.findById(id).get();
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepo.deleteById(id);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeRepo.save(employee);
    }
}
