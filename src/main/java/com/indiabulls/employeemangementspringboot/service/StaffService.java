package com.indiabulls.employeemangementspringboot.service;

import com.indiabulls.employeemangementspringboot.model.Staff;

import java.util.List;

public interface StaffService {
    Staff saveStaff(Staff staff);
    Staff login(String username, String password);

    List<Staff> getAllStaff();

}
