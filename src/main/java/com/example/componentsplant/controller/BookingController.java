package com.example.componentsplant.controller;

import com.example.componentsplant.dto.BookingDTO;
import com.example.componentsplant.service.BookingService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Data
@RestController
@RequestMapping (value = "/orders", produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
public class BookingController {
    
    private final BookingService bookingService;

    @PostMapping(value = "/{bookingID}")
    @ResponseStatus(HttpStatus.OK)
    public BookingDTO watchBookingByID (@PathVariable("bookingID") final Long bookingID) {
        return bookingService.getBookingByID(bookingID);
    }
}
