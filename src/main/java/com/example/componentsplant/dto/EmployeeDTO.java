package com.example.componentsplant.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class EmployeeDTO {

    private String fio;
    private Gender gender;
    private String login;
    private String password;
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate dateOfBirth;
    private String position;
}
