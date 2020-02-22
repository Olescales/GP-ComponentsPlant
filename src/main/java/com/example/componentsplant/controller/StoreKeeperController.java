package com.example.componentsplant.controller;

import com.example.componentsplant.dto.BookingDTO;
import com.example.componentsplant.service.StoreKeeperService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Data
@RestController

public class StoreKeeperController {

    private final StoreKeeperService storeKeeperService;

    @GetMapping (value = "/storekeeper/orders", produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    @ResponseStatus(HttpStatus.OK)
    public List<BookingDTO> watchOrders () {
        return storeKeeperService.watchOrders();
    }

}
