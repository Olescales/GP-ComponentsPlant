package com.example.componentsplant.dto;

import lombok.Data;

import java.util.List;

@Data
public class ClientDTO {
    private Goods clientID;
    private String name;
    private String legaladdress;
    private String payernumber;
    private String country;
    private String bankaccount;
    private String email;
    private String password;
    private double discount;
    private List<EmployeeDTO> employees;
}
