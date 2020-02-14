package com.example.componentsplant.entity;

import com.example.componentsplant.dto.Gender;
import com.example.componentsplant.security.UserRole;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class StaffEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String fio;
    private Gender gender;
    private Integer age;
    private String position;

    private UserRole userRole;

    private Double salary;
    private String department;
    private String workExperience;


}
