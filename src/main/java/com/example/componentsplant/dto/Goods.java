package com.example.componentsplant.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Goods {

    private Long goodsID;
    private String name;
    private String type;
    private String description;
    private Double netcost;
    private Double releasecost;
    private Long stocknumber;
}
