package com.example.componentsplant.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class OrderItemEntity {
        @Id
        @GeneratedValue (strategy = GenerationType.AUTO)
        private Long id;
        private Integer quantity;
        @OneToOne
        @JoinColumn
        private GoodsEntity goods;
}
