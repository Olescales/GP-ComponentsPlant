package com.example.componentsplant.mapper;


import com.example.componentsplant.dto.OrderDTO;
import com.example.componentsplant.entity.OrderEntity;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface OrderDTOMapper {

    OrderEntity sourceToDestination (OrderDTO source);

    OrderDTO destinationToSource(OrderEntity destination);
}
