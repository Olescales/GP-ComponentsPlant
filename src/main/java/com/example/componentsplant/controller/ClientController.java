package com.example.componentsplant.controller;

import com.example.componentsplant.dto.BookingDTO;
import com.example.componentsplant.dto.BookingNumberDTO;
import com.example.componentsplant.dto.Message;
import com.example.componentsplant.exception.NotEnoughGoodsInStock;
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

    @PostMapping(value = "/clients/{clientID}/orders", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public BookingNumberDTO makeOrder (@PathVariable final Long clientID, @RequestBody final BookingDTO request) throws NotEnoughGoodsInStock {
        return clientService.makeOrder(clientID, request);
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

    @GetMapping(value = "/clients/{clientID}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<BookingDTO> watchOrderStory(@PathVariable final Long clientID) {
        return clientService.watchOrder(clientID);
    }
}

