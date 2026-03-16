package com.indiabulls.employeemangementspringboot.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StaffRequestDTO {
    private String username;

    private String password;

    private String email;

    private String role;
}
