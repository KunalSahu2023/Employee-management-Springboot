package com.indiabulls.employeemangementspringboot.controller;

import com.indiabulls.employeemangementspringboot.dto.request.StaffRequestDTO;
import com.indiabulls.employeemangementspringboot.dto.response.StaffResponseDTO;
import com.indiabulls.employeemangementspringboot.service.StaffService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {

    private final StaffService staffService;

    public StaffController(StaffService staffService){
        this.staffService=staffService;
    }

    @PostMapping("/register")
    public StaffResponseDTO register(
            @RequestBody StaffRequestDTO dto){

        return staffService.saveStaff(dto);
    }

    @PostMapping("/login")
    public StaffResponseDTO login(
            @RequestBody StaffRequestDTO dto){

        return staffService.login(
                dto.getUsername(),
                dto.getPassword()
        );
    }

    @GetMapping
    public List<StaffResponseDTO> getAll(){

        return staffService.getAllStaff();
    }
}