package com.indiabulls.employeemangementspringboot.service.impl;

import com.indiabulls.employeemangementspringboot.model.Employee;
import com.indiabulls.employeemangementspringboot.repository.EmployeeRepo;
import com.indiabulls.employeemangementspringboot.service.EmployeeService;
import com.indiabulls.employeemangementspringboot.service.FirestoreService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepo employeeRepo;
    private final FirestoreService firestoreService;
    public EmployeeServiceImpl(EmployeeRepo employeeRepo,
                               FirestoreService firestoreService){

        this.employeeRepo=employeeRepo;
        this.firestoreService=firestoreService;
    }

    @Transactional
    @Override
    public Employee saveEmployee(Employee employee) {

        //PostgreSQL
        Employee savedEmployee =
                employeeRepo.save(employee);

        //Firestore logging
        firestoreService.saveLog(
                savedEmployee.getId(),
                savedEmployee.getFirstName(),
                "CREATED"
        );
        return savedEmployee;
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee getEmployee(Long id) {
        return employeeRepo.findById(id).orElseThrow(() -> new RuntimeException("Employee not found with id : " + id));
    }

    @Override
    public void deleteEmployee(Long id) {

        if(!employeeRepo.existsById(id)){
            throw new RuntimeException("Employee not found");
        }

        employeeRepo.deleteById(id);

        firestoreService.saveLog(
                id,
                "EMPLOYEE",
                "DELETED"
        );
    }

    @Transactional
    @Override
    public Employee updateEmployee(Employee employee) {

        Employee existingEmployee = employeeRepo.findById(employee.getId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setDepartment(employee.getDepartment());
        existingEmployee.setSalary(employee.getSalary());

        Employee updated=employeeRepo.save(existingEmployee);
        firestoreService.saveLog(
                updated.getId(),
                updated.getFirstName(),
                "UPDATED"
        );

        return updated;
    }
}
