package com.example.componentsplant.service;

import com.example.componentsplant.dto.Message;
import com.example.componentsplant.dto.OrderCondition;
import com.example.componentsplant.dto.OrderDTO;
import com.example.componentsplant.entity.OrderEntity;
import com.example.componentsplant.mapper.OrderDTOMapper;
import com.example.componentsplant.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ClientService {

    private final OrderDTOMapper orderDTOMapper;
    private final OrderRepository orderRepository;

    public OrderDTO makeOrder (final OrderDTO request) {
        final OrderEntity orderEntity = orderDTOMapper.sourceToDestination(request);
        return orderDTOMapper.destinationToSource(orderRepository.save(orderEntity));
    }

    public Message deleteOrder (final Long orderID) {
        return Message.builder().response("Заказ удалён!").build();
    }

    public Message changeOrder (final Long orderID, final  OrderDTO orderDTO) {
        return Message.builder().response("Заказ обновлён").build();
    }

    public List<OrderDTO> watchOrder () {
        final List<OrderDTO> orderDTOList = new ArrayList<>();
        orderDTOList.add(OrderDTO.builder().orderID(1L).sum(1000L).orderCondition(OrderCondition.SHIPPED).build());
        orderDTOList.add(OrderDTO.builder().orderID(2L).sum(2500L).orderCondition(OrderCondition.READYFORSHIPMENT).build());
        return orderDTOList;
    }
}
