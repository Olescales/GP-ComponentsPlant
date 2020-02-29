package com.example.componentsplant.service;

import com.example.componentsplant.dto.BookingAggregator;
import com.example.componentsplant.dto.BookingDTO;
import com.example.componentsplant.repository.BookingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class DirectorService {

    private BookingRepository bookingRepository;

    public BookingAggregator watchProfitGlassGoods (final String glassGoods, final BookingDTO request) {
        return BookingAggregator.builder().totalSumOfProfit(25000d).build();
    }

    public BookingAggregator watchTotalSumOfOrders (final String orderDate) {
        final LocalDate date = LocalDate.parse(orderDate);
        Double result = bookingRepository.findSumByOrderdate(date);
        return BookingAggregator.builder().totalSumOfOrders(result).build();
    }
}
