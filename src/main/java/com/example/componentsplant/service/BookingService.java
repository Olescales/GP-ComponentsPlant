package com.example.componentsplant.service;

import com.example.componentsplant.dto.BookingDTO;
import com.example.componentsplant.mapper.BookingDTOMapper;
import com.example.componentsplant.repository.BookingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;

    private final BookingDTOMapper bookingDTOMapper;


    public BookingDTO getBookingByID (final Long bookingID) {
        return bookingDTOMapper.destinationToSource(bookingRepository.findBookingEntityById(bookingID));
    }

}
