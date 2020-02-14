package com.example.componentsplant.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class EmployeeSignInRequest {

    private final String email;
    private final String password;

}
