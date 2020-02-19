package com.example.componentsplant.mapper;


import com.example.componentsplant.dto.OrderDTO;
import com.example.componentsplant.entity.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface OrderDTOMapper {
    @Mappings({
            @Mapping(target = "id", source = "orderID")
    })
    OrderEntity sourceToDestination(OrderDTO source);

    @Mappings({
            @Mapping(target = "orderID", source = "id")
    })
    OrderDTO destinationToSource(OrderEntity destination);
}
