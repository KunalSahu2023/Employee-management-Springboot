package com.indiabulls.employeemangementspringboot.service;

import com.indiabulls.employeemangementspringboot.dto.request.EmployeeRequestDTO;
import com.indiabulls.employeemangementspringboot.dto.response.EmployeeResponseDTO;

import java.util.List;

public interface EmployeeService {

    EmployeeResponseDTO saveEmployee(EmployeeRequestDTO dto);

    List<EmployeeResponseDTO> getEmployees();

    EmployeeResponseDTO getEmployee(Long id);

    void deleteEmployee(Long id);

    EmployeeResponseDTO updateEmployee(Long id,EmployeeRequestDTO dto);

}