package com.example.componentsplant.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class ClientEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String legalAddress;
    private String accountNumberOfTheTaxpayer;
    private String country;
    private String bankAccount;
    private double discountCoefficient;
}
