package com.example.componentsplant.dto;

import lombok.Data;

@Data
public class ClientDTO {
    private Long clientID;
    private String name;
    private String legalAddress;
    private String accountNumberOfTheTaxpayer;
    private String country;
    private String bankAccount;
    private String email;
    private String password;
    private double discountCoefficient;

}
