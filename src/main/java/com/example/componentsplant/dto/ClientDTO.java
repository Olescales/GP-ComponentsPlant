package com.example.componentsplant.dto;

import lombok.Data;

import java.util.List;

@Data
public class ClientDTO {
    private Long clientID;
    private String name;
    private String legalAddress;
    private String accountNumberOfTheTaxpayer;
    private String country;
    private String bankAccount;
    private String login;
    private String password;
    private double discountCoefficient;
    private List<EmployeeDTO> employees;
}
