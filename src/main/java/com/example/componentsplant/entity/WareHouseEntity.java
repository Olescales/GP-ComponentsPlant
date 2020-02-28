package com.example.componentsplant.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity (name = "warehouse")
public class WareHouseEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "goods_id", nullable = false)
    private GoodsEntity goodsEntity;

    private Long reserve;
}
