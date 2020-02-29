package com.example.componentsplant.service;

import com.example.componentsplant.dto.BookingAggregator;
import com.example.componentsplant.dto.GoodsDTO;
import com.example.componentsplant.mapper.GoodsMapper;
import com.example.componentsplant.repository.BookingRepository;
import com.example.componentsplant.repository.GoodsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DirectorService {

    private BookingRepository bookingRepository;
    private GoodsRepository goodsRepository;

    private GoodsMapper goodsMapper;

    public List<GoodsDTO> watchAssortmentOfGoodsByType(final String type) {
        return goodsRepository.getGoodsEntitiesByType(type).stream().map(goodsMapper::destinationToSource).collect(Collectors.toList());
    }

    public BookingAggregator watchTotalSumOfOrders(final String orderDate) {
        final LocalDate date = LocalDate.parse(orderDate);
        final Double result = bookingRepository.findSumByOrderdate(date);
        return BookingAggregator.builder().totalSumOfOrders(result).build();
    }
}
