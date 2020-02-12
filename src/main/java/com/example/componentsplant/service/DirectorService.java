package com.example.componentsplant.service;

import com.example.componentsplant.dto.OrdersAggregator;
import org.springframework.stereotype.Service;

@Service
public class DirectorService {

    public OrdersAggregator watchProfitGlassGoods (final String glassGoods) {
        return OrdersAggregator.builder().totalSumOfProfit(25000d).build();
    }

    public OrdersAggregator watchTotalSumOfOrders () {
        return OrdersAggregator.builder().totalSumOfOrders(123456d).build();
    }
}
