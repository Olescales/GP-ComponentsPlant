package com.example.componentsplant.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Goods {
    private String name;
    private String type;
    private String description;
    private Double netCost;
    private Long releaseCost;
    private Long storeID;
}
