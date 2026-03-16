package com.indiabulls.employeemangementspringboot.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StaffResponseDTO {
    private Long id;

    private String username;

    private String email;

    private String role;
}
