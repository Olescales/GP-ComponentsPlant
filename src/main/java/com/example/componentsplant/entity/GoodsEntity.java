package com.example.componentsplant.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity (name = "goods")
public class GoodsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;
    private String description;
    private Double netcost;
    private Double releasecost;
    private Long stocknumber;

    @OneToOne (mappedBy = "goodsEntity", cascade = CascadeType.ALL)
    private WareHouseEntity wareHouseEntity;
}
