package com.example.componentsplant.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity (name = "client")
public class ClientEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "client_id")
    private Long id;

    private String name;
    private String legalAddress;
    private String accountNumberOfTheTaxpayer;
    private String country;
    private String bankAccount;
    private double discountCoefficient;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn (name = "booking_id")
    private List<BookingEntity> bookings;
}
