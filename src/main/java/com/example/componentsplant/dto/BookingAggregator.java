package com.example.componentsplant.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookingAggregator {

    private Double totalSumOfOrders;
    private Double totalSumOfProfit;

}
