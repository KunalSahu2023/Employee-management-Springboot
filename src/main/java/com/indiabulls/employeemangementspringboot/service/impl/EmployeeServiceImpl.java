package com.indiabulls.employeemangementspringboot.service.impl;

import com.indiabulls.employeemangementspringboot.dto.request.EmployeeRequestDTO;
import com.indiabulls.employeemangementspringboot.dto.response.EmployeeResponseDTO;
import com.indiabulls.employeemangementspringboot.model.Employee;
import com.indiabulls.employeemangementspringboot.model.Staff;
import com.indiabulls.employeemangementspringboot.repository.EmployeeRepo;
import com.indiabulls.employeemangementspringboot.repository.StaffRepo;
import com.indiabulls.employeemangementspringboot.service.EmployeeService;
import com.indiabulls.employeemangementspringboot.service.FirestoreService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepo employeeRepo;
    private final StaffRepo staffRepo;
    private final FirestoreService firestoreService;

    public EmployeeServiceImpl(EmployeeRepo employeeRepo,
                               StaffRepo staffRepo,
                               FirestoreService firestoreService){

        this.employeeRepo=employeeRepo;
        this.staffRepo=staffRepo;
        this.firestoreService=firestoreService;
    }

    @Transactional
    public EmployeeResponseDTO saveEmployee(EmployeeRequestDTO dto){

        Staff staff = staffRepo.findById(dto.getStaffId())
                .orElseThrow(()->new RuntimeException("Staff not found"));

        Employee employee = new Employee();

        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setEmail(dto.getEmail());
        employee.setDepartment(dto.getDepartment());
        employee.setSalary(dto.getSalary());
        employee.setStaff(staff);

        Employee saved = employeeRepo.save(employee);

        firestoreService.saveLog(
                saved.getId(),
                saved.getFirstName(),
                "CREATED"
        );

        return mapToResponse(saved);
    }

    public List<EmployeeResponseDTO> getEmployees(){

        return employeeRepo.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public EmployeeResponseDTO getEmployee(Long id){

        Employee employee = employeeRepo.findById(id)
                .orElseThrow(()->new RuntimeException("Employee not found"));

        return mapToResponse(employee);
    }

    public void deleteEmployee(Long id){

        employeeRepo.deleteById(id);

        firestoreService.saveLog(
                id,
                "EMPLOYEE",
                "DELETED"
        );
    }

    @Transactional
    public EmployeeResponseDTO updateEmployee(Long id,
                                              EmployeeRequestDTO dto){

        Employee employee = employeeRepo.findById(id)
                .orElseThrow(()->new RuntimeException("Employee not found"));

        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setEmail(dto.getEmail());
        employee.setDepartment(dto.getDepartment());
        employee.setSalary(dto.getSalary());

        Employee updated = employeeRepo.save(employee);

        firestoreService.saveLog(
                updated.getId(),
                updated.getFirstName(),
                "UPDATED"
        );

        return mapToResponse(updated);
    }

    private EmployeeResponseDTO mapToResponse(Employee employee){

        return new EmployeeResponseDTO(

                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartment(),
                employee.getSalary(),
                employee.getStaff()!=null ?
                        employee.getStaff().getUsername()
                        : null
        );
    }
}