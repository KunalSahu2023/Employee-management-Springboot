package com.indiabulls.employeemangementspringboot.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EmployeeRequestDTO {
    private String firstName;

    private String lastName;

    private String email;

    private String department;

    private Double salary;

    private Long staffId;
}
