package com.example.componentsplant.mapper;


import com.example.componentsplant.dto.BookingDTO;
import com.example.componentsplant.entity.BookingEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface BookingDTOMapper {
    @Mappings({
            @Mapping(target = "client.id", source = "source.clientID"),
            @Mapping(target = "bookingItemEntities", source = "source.goods")
    })
    BookingEntity sourceToDestination(BookingDTO source);

    @Mappings({
            @Mapping(target = "clientID", source = "destination.client.id"),
            @Mapping(target = "goods", source = "destination.bookingItemEntities")
    })
    BookingDTO destinationToSource(BookingEntity destination);
}
