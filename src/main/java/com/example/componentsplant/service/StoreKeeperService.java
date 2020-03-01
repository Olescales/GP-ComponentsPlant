package com.example.componentsplant.service;

import com.example.componentsplant.dto.BookingDTO;
import com.example.componentsplant.entity.BookingEntity;
import com.example.componentsplant.exception.NoSuchBookings;
import com.example.componentsplant.mapper.BookingDTOMapper;
import com.example.componentsplant.repository.BookingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StoreKeeperService {


    private BookingRepository bookingRepository;

    private BookingDTOMapper bookingDTOMapper;

    public List<BookingDTO> watchOrders(final String condition) throws NoSuchBookings {
        List<BookingEntity> bookingEntities = bookingRepository.findByCondition(condition);
        if (bookingEntities.isEmpty()) {
            throw new NoSuchBookings("There is no such bookings.");
        } else {
            return bookingEntities.stream().map(bookingDTOMapper::destinationToSource).collect(Collectors.toList());
        }
    }
}
