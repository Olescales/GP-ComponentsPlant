package com.example.componentsplant.service;

import com.example.componentsplant.dto.BookingCondition;
import com.example.componentsplant.dto.BookingDTO;
import com.example.componentsplant.dto.Goods;
import com.example.componentsplant.dto.OrderItem;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StoreKeeperService {

    public List<BookingDTO> watchOrders () {
        List<OrderItem> goodsList1 = new ArrayList<>();
        goodsList1.add(OrderItem.builder().commodity(Goods.builder().stockNumber(111L).build()).quantity(10).build());
        goodsList1.add(OrderItem.builder().commodity(Goods.builder().stockNumber(207L).build()).quantity(5).build());
        List<OrderItem> goodsList2 = new ArrayList<>();
        goodsList2.add(OrderItem.builder().commodity(Goods.builder().stockNumber(117L).build()).quantity(11).build());
        goodsList2.add(OrderItem.builder().commodity(Goods.builder().stockNumber(189L).build()).quantity(4).build());

        List<BookingDTO> orderDTOList = new ArrayList<>();
        orderDTOList.add(BookingDTO.builder().bookingID(41L).goods(goodsList1).bookingCondition(BookingCondition.ASSEMBLING).clientID(41L).build());
        orderDTOList.add(BookingDTO.builder().bookingID(23L).goods(goodsList2).bookingCondition(BookingCondition.ASSEMBLING).clientID(52L).build());
        return orderDTOList;

    }
}
