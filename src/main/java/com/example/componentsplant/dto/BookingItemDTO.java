package com.example.componentsplant.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookingItemDTO {

    private Long goodsID;
    private Integer quantity;

}
