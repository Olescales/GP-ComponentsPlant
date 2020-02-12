package com.example.componentsplant.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrdersAgregator {

    private Double totalSumOfOrders;
    private Double totalSumOfProfit;

}
