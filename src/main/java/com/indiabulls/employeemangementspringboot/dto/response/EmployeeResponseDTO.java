package com.indiabulls.employeemangementspringboot.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EmployeeResponseDTO {
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String department;

    private Double salary;

    private String staffName;
}
