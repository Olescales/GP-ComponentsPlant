package com.example.componentsplant.dto;

import lombok.Data;

@Data
public class EmployeeSignInRequest {

    private final String login;
    private final String password;

}
