package com.example.componentsplant.entity;

import com.example.componentsplant.dto.Gender;
import com.example.componentsplant.security.UserRole;
import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class StaffEntity {

    private String fio;
    private Gender gender;
    private Integer age;
    private String position;

    private UserRole userRole;

    private Double salary;
    private String department;
    private String workExperience;


}
