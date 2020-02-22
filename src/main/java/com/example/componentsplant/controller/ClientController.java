package com.example.componentsplant.controller;

import com.example.componentsplant.dto.BookingDTO;
import com.example.componentsplant.dto.Message;
import com.example.componentsplant.service.ClientService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Data
@RestController
public class ClientController {

    private final ClientService clientService;

    @PostMapping(value = "/clients/1/orders", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public BookingDTO makeOrder (@RequestBody final BookingDTO request) {
        return clientService.makeOrder(request);
    }

    @PostMapping(value = "/clients/1/orders/{orderID}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Message changeOrder (@PathVariable("orderID") final Long orderID, @RequestBody final BookingDTO request) {
        return clientService.changeOrder(orderID, request);
    }

    @DeleteMapping(value = "/clients/1/orders/{orderID}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Message deleteOrder (@PathVariable("orderID") final Long orderID) {
        return clientService.deleteOrder(orderID);
    }

    @GetMapping(value = "/clients/1", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<BookingDTO> watchOrderStory () {
        return clientService.watchOrder();
    }
}

