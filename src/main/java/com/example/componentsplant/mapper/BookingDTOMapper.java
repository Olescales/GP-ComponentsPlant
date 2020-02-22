package com.example.componentsplant.mapper;


import com.example.componentsplant.dto.BookingDTO;
import com.example.componentsplant.entity.BookingEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface BookingDTOMapper {
    @Mappings({
            @Mapping(target = "id", source = "bookingID")
    })
    BookingEntity sourceToDestination(BookingDTO source);

    @Mappings({
            @Mapping(target = "bookingID", source = "id")
    })
    BookingDTO destinationToSource(BookingEntity destination);
}
