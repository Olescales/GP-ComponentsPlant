package com.example.componentsplant.service;

import com.example.componentsplant.dto.Goods;
import com.example.componentsplant.dto.Message;
import com.example.componentsplant.dto.OrderCondition;
import com.example.componentsplant.dto.OrderDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {

    public Message changePrice (final Long storeID, Goods goods) {
        return Message.builder().response("Price changed.").build();
    }

    public List<OrderDTO> watchOrdersOnApprovement () {
        List<OrderDTO> orderDTOList = new ArrayList<>();
        orderDTOList.add(OrderDTO.builder().orderID(43L).sum(1230L).orderCondition(OrderCondition.ONAPPROVEMENT).clientID(1L).build());
        orderDTOList.add(OrderDTO.builder().orderID(32L).sum(1470L).orderCondition(OrderCondition.ONAPPROVEMENT).clientID(2L).build());
        return orderDTOList;
    }

    public Goods createGoods (Goods goods) {
        return Goods.builder().stockNumber(321L).build();
    }


}
