package com.example.componentsplant.service;

import com.example.componentsplant.dto.OrderCondition;
import com.example.componentsplant.dto.OrderDTO;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ClientService {

    public OrderDTO makeOrder (OrderDTO request) {
        return OrderDTO.builder().orderID("123").build();
    }

    public Message deleteOrder (final Long orderID) {
        return Message.builder().response("Заказ удалён!").build();
    }

    public Message changeOrder (final Long orderID, OrderDTO orderDTO) {
        return Message.builder().response("Заказ обновлён").build();
    }

    public List<OrderDTO> watchOrder () {
        List<OrderDTO> orderDTOList = new ArrayList<>();
        orderDTOList.add(OrderDTO.builder().orderID("1").sum(1000L).orderCondition(OrderCondition.SHIPPED).build());
        orderDTOList.add(OrderDTO.builder().orderID("2").sum(2500L).orderCondition(OrderCondition.READYFORSHIPMENT).build());
        for (OrderDTO order: orderDTOList) {
            System.out.println(order);
        }
        return orderDTOList;
    }
}
