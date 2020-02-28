package com.example.componentsplant.controller;

import com.example.componentsplant.dto.BookingDTO;
import com.example.componentsplant.dto.BookingNumberDTO;
import com.example.componentsplant.dto.Message;
import com.example.componentsplant.exception.NotEnoughGoodsInTheStock;
import com.example.componentsplant.service.ClientService;
import lombok.Data;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Log
@Data
@RestController
public class ClientController {

    private final ClientService clientService;

    @PostMapping(value = "/clients/{clientID}/orders", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public BookingNumberDTO makeOrder (@PathVariable ("clientID") final Long clientID, @RequestBody final BookingDTO request) throws NotEnoughGoodsInTheStock {
        request.setClientID(clientID);
        return clientService.makeOrder(clientID, request);
    }

    @PostMapping(value = "/clients/1/orders/{orderID}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Message changeOrder (@PathVariable("orderID") final Long orderID, @RequestBody final BookingDTO request) {
        log.info(request.toString());
        request.setBookingID(orderID);
        return clientService.changeOrder(request);
    }

    @DeleteMapping(value = "/clients/1/orders/{orderID}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Message deleteOrder (@PathVariable("orderID") final Long orderID) {
        return clientService.deleteOrder(orderID);
    }

    @GetMapping(value = "/clients/{clientID}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<BookingDTO> watchOrderStory(@PathVariable("clientID") final Long clientID) {
        return clientService.watchOrderStory(clientID);
    }
}

