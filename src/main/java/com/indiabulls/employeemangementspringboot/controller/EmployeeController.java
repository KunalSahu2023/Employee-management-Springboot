package com.indiabulls.employeemangementspringboot.controller;

import com.indiabulls.employeemangementspringboot.dto.request.EmployeeRequestDTO;
import com.indiabulls.employeemangementspringboot.dto.response.EmployeeResponseDTO;
import com.indiabulls.employeemangementspringboot.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    @PostMapping
    public ResponseEntity<EmployeeResponseDTO>
    createEmployee(@RequestBody EmployeeRequestDTO dto){

        return ResponseEntity.ok(
                employeeService.saveEmployee(dto));
    }

    @GetMapping
    public List<EmployeeResponseDTO> getEmployees(){

        return employeeService.getEmployees();
    }

    @GetMapping("/{id}")
    public EmployeeResponseDTO getEmployee(@PathVariable Long id){

        return employeeService.getEmployee(id);
    }

    @PutMapping("/{id}")
    public EmployeeResponseDTO updateEmployee(
            @PathVariable Long id,
            @RequestBody EmployeeRequestDTO dto){

        return employeeService.updateEmployee(id,dto);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id){

        employeeService.deleteEmployee(id);
    }
}