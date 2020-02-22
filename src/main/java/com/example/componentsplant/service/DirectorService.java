package com.example.componentsplant.service;

import com.example.componentsplant.dto.BookingAggregator;
import org.springframework.stereotype.Service;

@Service
public class DirectorService {

    public BookingAggregator watchProfitGlassGoods (final String glassGoods) {
        return BookingAggregator.builder().totalSumOfProfit(25000d).build();
    }

    public BookingAggregator watchTotalSumOfOrders () {
        return BookingAggregator.builder().totalSumOfOrders(123456d).build();
    }
}
