package com.example.componentsplant.service;

import com.example.componentsplant.dto.*;
import com.example.componentsplant.dto.Goods;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {

    public Message changePrice (final java.lang.Long storeID, Goods aGoods) {
        return Message.builder().response("Price changed.").build();
    }

    public List<BookingDTO> watchOrdersOnApprovement () {
        List<BookingDTO> orderDTOList = new ArrayList<>();
        return orderDTOList;
    }

    public Goods createGoods (Goods aGoods) {
        return Goods.builder().stocknumber(321L).build();
    }


}
