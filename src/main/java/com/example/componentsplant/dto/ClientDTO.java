package com.example.componentsplant.dto;

import lombok.Data;

@Data
public class ClientDTO {
    private String name;
    private String legalAddress;
    private String accountNumberOfTheTaxpayer;
    private String country;
    private String bankAccount;
    private String email;
    private String password;
    private double discountCoefficient;

    public ClientDTO() {
    }

    public ClientDTO(String name, String legalAddress, String accountNumberOfTheTaxpayer, String country, String bankAccount, String email, String password, double discountCoefficient) {
        this.name = name;
        this.legalAddress = legalAddress;
        this.accountNumberOfTheTaxpayer = accountNumberOfTheTaxpayer;
        this.country = country;
        this.bankAccount = bankAccount;
        this.email = email;
        this.password = password;
        this.discountCoefficient = discountCoefficient;
    }

    @Override
    public String toString() {
        return "ClientDTO{" +
                "name='" + name + '\'' +
                ", legalAddress='" + legalAddress + '\'' +
                ", accountNumberOfTheTaxpayer='" + accountNumberOfTheTaxpayer + '\'' +
                ", country='" + country + '\'' +
                ", bankAccount='" + bankAccount + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' + '}';
    }
}
