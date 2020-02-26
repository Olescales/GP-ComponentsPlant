package com.example.componentsplant.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity (name = "booking_item")
public class BookingItemEntity {

        @Id
        @GeneratedValue (strategy = GenerationType.AUTO)
        private Long id;
        private Integer quantity;

        @ManyToOne
        @JoinColumn (name = "goods_id", nullable = false)
        private GoodsEntity commodity;

        @ManyToOne (cascade = CascadeType.ALL)
        @JoinColumn (name = "booking_id", nullable = false)
        private BookingEntity bookingEntity;
}