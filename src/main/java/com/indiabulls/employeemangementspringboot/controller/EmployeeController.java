package com.indiabulls.employeemangementspringboot.controller;

import com.indiabulls.employeemangementspringboot.model.Employee;
import com.indiabulls.employeemangementspringboot.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeRepo employeeRepo;
    @Autowired
    public void setEmployeeRepo(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepo.save(employee);
    }

    @GetMapping
    public List<Employee> getEmployees() {
        return employeeRepo.findAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@RequestParam int id) {
        return employeeRepo.findById(id).get();
    }

    @PutMapping("{id}")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeRepo.save(employee);
    }

    @DeleteMapping
    public void deleteEmployee(@RequestParam int id) {
        employeeRepo.deleteById(id);
    }
}
