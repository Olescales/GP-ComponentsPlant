package com.example.componentsplant.mapper;

import com.example.componentsplant.dto.BookingItemDTO;
import com.example.componentsplant.entity.BookingItemEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper (componentModel = "spring")
public interface BookingItemMapper {

    @Mappings({
            @Mapping(target = "commodity.id", source = "source.goodsID")
    })
    BookingItemEntity sourceToDestination (BookingItemDTO source);
    
    @Mappings({
            @Mapping(target = "goodsID", source = "destination.commodity.id"),
    })
    BookingItemDTO destinationToSource (BookingItemEntity destination);

}
