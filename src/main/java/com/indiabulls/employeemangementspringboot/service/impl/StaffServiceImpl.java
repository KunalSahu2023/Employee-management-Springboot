package com.indiabulls.employeemangementspringboot.service.impl;

import com.indiabulls.employeemangementspringboot.model.Staff;
import com.indiabulls.employeemangementspringboot.repository.StaffRepo;
import com.indiabulls.employeemangementspringboot.service.StaffService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {

    private StaffRepo staffRepo;

    public StaffServiceImpl(StaffRepo staffRepo){
        this.staffRepo=staffRepo;
    }

    public Staff saveStaff(Staff staff){

        return staffRepo.save(staff);
    }

    public Staff login(String username,String password){

        Staff staff = staffRepo.findByUsername(username);

        if(staff==null){
            throw new RuntimeException("User not found");
        }

        if(!staff.getPassword().equals(password)){
            throw new RuntimeException("Invalid password");
        }

        return staff;
    }

    @Override
    public List<Staff> getAllStaff(){
        return staffRepo.findAll();
    }

}
