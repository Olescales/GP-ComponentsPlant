package com.example.componentsplant.service;

import com.example.componentsplant.dto.Message;
import com.example.componentsplant.dto.OrderCondition;
import com.example.componentsplant.dto.OrderDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {

    public OrderDTO makeOrder (OrderDTO request) {
        return OrderDTO.builder().orderID(123L).build();
    }

    public Message deleteOrder (final Long orderID) {
        return Message.builder().response("Заказ удалён!").build();
    }

    public Message changeOrder (final Long orderID, OrderDTO orderDTO) {
        return Message.builder().response("Заказ обновлён").build();
    }

    public List<OrderDTO> watchOrder () {
        List<OrderDTO> orderDTOList = new ArrayList<>();
        orderDTOList.add(OrderDTO.builder().orderID(1L).sum(1000L).orderCondition(OrderCondition.SHIPPED).build());
        orderDTOList.add(OrderDTO.builder().orderID(2L).sum(2500L).orderCondition(OrderCondition.READYFORSHIPMENT).build());
        return orderDTOList;
    }
}
