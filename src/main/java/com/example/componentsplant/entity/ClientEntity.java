package com.example.componentsplant.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity (name = "client")
public class ClientEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String legaladdress;
    private String payernumber;
    private String country;
    private String bankaccount;
    private double discount;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<BookingEntity> bookings;
}
