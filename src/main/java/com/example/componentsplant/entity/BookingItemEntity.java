package com.example.componentsplant.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity (name = "booking_item")
public class BookingItemEntity {

        @Id
        @GeneratedValue (strategy = GenerationType.AUTO)
        @Column (name = "booking_item_id")
        private Long id;
        private Integer quantity;

        @OneToOne (cascade = CascadeType.ALL)
        @JoinColumn (name = "goods_id", nullable = false)
        private GoodsEntity commodity;

        @ManyToOne
        @JoinColumn (name = "booking_id", nullable = false)
        private BookingEntity bookingEntity;
}