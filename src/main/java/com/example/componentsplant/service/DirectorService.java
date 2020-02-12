package com.example.componentsplant.service;

import com.example.componentsplant.dto.OrdersAgregator;
import org.springframework.stereotype.Service;

@Service
public class DirectorService {

    public OrdersAgregator watchProfitGlassGoods (final String glassGoods) {
        return OrdersAgregator.builder().totalSumOfProfit(25000d).build();
    }

    public OrdersAgregator watchTotalSumOfOrders () {
        return OrdersAgregator.builder().totalSumOfOrders(123456d).build();
    }
}
