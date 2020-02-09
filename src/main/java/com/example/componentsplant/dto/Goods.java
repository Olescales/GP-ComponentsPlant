package com.example.componentsplant.dto;

import lombok.Data;

@Data
public class Goods {
    private String name;
    private String type;
    private String descryption;
    private Double netCost;
    private Double releaseCost;
    private Long storeID;
}
