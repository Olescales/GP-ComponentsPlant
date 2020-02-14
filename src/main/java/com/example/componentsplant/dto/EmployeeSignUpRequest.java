package com.example.componentsplant.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EmployeeSignUpRequest {

    private String companyName;
    private String email;
    private String password;
    private String fio;
    private Gender gender;
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate birthDate;
    private String selfDescription;
}
