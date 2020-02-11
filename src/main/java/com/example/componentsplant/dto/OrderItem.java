package com.example.componentsplant.dto;

import lombok.Data;

@Data
public class OrderItem {

    private Goods goods;
    private Integer quantity;

}
