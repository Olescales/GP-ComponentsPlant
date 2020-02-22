package com.example.componentsplant.service;

import com.example.componentsplant.dto.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {

    public Message changePrice (final Long storeID, Goods goods) {
        return Message.builder().response("Price changed.").build();
    }

    public List<BookingDTO> watchOrdersOnApprovement () {
        List<BookingDTO> orderDTOList = new ArrayList<>();
        orderDTOList.add(BookingDTO.builder().bookingID(43L).sum(1230L).bookingCondition(BookingCondition.ONAPPROVEMENT).clientID(1L).build());
        orderDTOList.add(BookingDTO.builder().bookingID(32L).sum(1470L).bookingCondition(BookingCondition.ONAPPROVEMENT).clientID(2L).build());
        return orderDTOList;
    }

    public Goods createGoods (Goods goods) {
        return Goods.builder().stockNumber(321L).build();
    }


}
