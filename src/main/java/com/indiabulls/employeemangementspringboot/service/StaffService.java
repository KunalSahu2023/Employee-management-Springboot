package com.indiabulls.employeemangementspringboot.service;

import com.indiabulls.employeemangementspringboot.dto.request.StaffRequestDTO;
import com.indiabulls.employeemangementspringboot.dto.response.StaffResponseDTO;

import java.util.List;

public interface StaffService {

    StaffResponseDTO saveStaff(StaffRequestDTO dto);

    StaffResponseDTO login(String username,String password);

    List<StaffResponseDTO> getAllStaff();

}