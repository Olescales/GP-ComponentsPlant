package com.example.componentsplant.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GoodsDTO {

    private Long goodsID;
    private String name;
    private String type;
    private String description;
    private Double netcost;
    private Double releasecost;
    private Long stocknumber;
}
