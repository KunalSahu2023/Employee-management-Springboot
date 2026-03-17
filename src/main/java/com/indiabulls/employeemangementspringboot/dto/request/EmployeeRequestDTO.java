package com.indiabulls.employeemangementspringboot.dto.request;

import jakarta.validation.constraints.NotNull;
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

    @NotNull
    private Long staffId;
}
