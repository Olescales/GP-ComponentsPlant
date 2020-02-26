package com.example.componentsplant.controller;

import com.example.componentsplant.dto.BookingDTO;
import com.example.componentsplant.service.BookingService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
public class BookingController {
    
    private final BookingService bookingService;

    @GetMapping(value = "/{bookingID}")
    @ResponseStatus(HttpStatus.OK)
    public BookingDTO watchBookingByID (@PathVariable("bookingID") final Long bookingID) {
        return bookingService.getBookingByID(bookingID);
    }
}
