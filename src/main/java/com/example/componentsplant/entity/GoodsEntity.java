package com.example.componentsplant.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity (name = "goods")
public class GoodsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String type;
    private String description;
    private Double netCost;
    private Long releaseCost;
    private Long stockNumber;
    
    @OneToOne (mappedBy = "commodity")
    private BookingItemEntity bookingItemEntity;
}
