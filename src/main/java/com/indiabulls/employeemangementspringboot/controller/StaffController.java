package com.indiabulls.employeemangementspringboot.controller;

import com.indiabulls.employeemangementspringboot.model.Staff;
import com.indiabulls.employeemangementspringboot.service.StaffService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {
    private StaffService staffService;

    public StaffController(StaffService staffService){
        this.staffService=staffService;
    }

    @PostMapping("/register")
    public Staff register(@RequestBody Staff staff){

        return staffService.saveStaff(staff);
    }

    @PostMapping("/login")
    public Staff login(@RequestBody Staff staff){

        return staffService.login(
                staff.getUsername(),
                staff.getPassword()
        );
    }

    @GetMapping
    public List<Staff> getAll(){

        return staffService.getAllStaff();
    }

}
