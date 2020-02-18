package com.example.componentsplant.service;

import com.example.componentsplant.dto.Goods;
import com.example.componentsplant.dto.OrderCondition;
import com.example.componentsplant.dto.OrderDTO;
import com.example.componentsplant.dto.OrderItem;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StoreKeeperService {

    public List<OrderDTO> watchOrders () {
        List<OrderItem> goodsList1 = new ArrayList<>();
        goodsList1.add(OrderItem.builder().goods(Goods.builder().storeID(111L).build()).quantity(10).build());
        goodsList1.add(OrderItem.builder().goods(Goods.builder().storeID(207L).build()).quantity(5).build());
        List<OrderItem> goodsList2 = new ArrayList<>();
        goodsList2.add(OrderItem.builder().goods(Goods.builder().storeID(117L).build()).quantity(11).build());
        goodsList2.add(OrderItem.builder().goods(Goods.builder().storeID(189L).build()).quantity(4).build());

        List<OrderDTO> orderDTOList = new ArrayList<>();
        orderDTOList.add(OrderDTO.builder().orderID(41L).goods(goodsList1).orderCondition(OrderCondition.ASSEMBLING).clientID(41L).build());
        orderDTOList.add(OrderDTO.builder().orderID(23L).goods(goodsList2).orderCondition(OrderCondition.ASSEMBLING).clientID(52L).build());
        return orderDTOList;

    }
}
