package com.indiabulls.employeemangementspringboot.service.impl;

import com.indiabulls.employeemangementspringboot.dto.request.StaffRequestDTO;
import com.indiabulls.employeemangementspringboot.dto.response.StaffResponseDTO;
import com.indiabulls.employeemangementspringboot.model.Staff;
import com.indiabulls.employeemangementspringboot.repository.StaffRepo;
import com.indiabulls.employeemangementspringboot.service.StaffService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StaffServiceImpl implements StaffService {

    private final StaffRepo staffRepo;

    public StaffServiceImpl(StaffRepo staffRepo){
        this.staffRepo=staffRepo;
    }

    public StaffResponseDTO saveStaff(StaffRequestDTO dto){

        Staff staff = new Staff();

        staff.setUsername(dto.getUsername());
        staff.setPassword(dto.getPassword());
        staff.setEmail(dto.getEmail());
        staff.setRole(dto.getRole());

        Staff saved = staffRepo.save(staff);

        return mapToResponse(saved);
    }

    public StaffResponseDTO login(String username,String password){

        Staff staff = staffRepo.findByUsername(username);

        if(staff==null){
            throw new RuntimeException("User not found");
        }

        if(!staff.getPassword().equals(password)){
            throw new RuntimeException("Invalid password");
        }

        return mapToResponse(staff);
    }

    public List<StaffResponseDTO> getAllStaff(){

        return staffRepo.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private StaffResponseDTO mapToResponse(Staff staff){

        return new StaffResponseDTO(

                staff.getId(),
                staff.getUsername(),
                staff.getEmail(),
                staff.getRole()
        );
    }
}