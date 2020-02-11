package com.example.componentsplant.controller;

import com.example.componentsplant.dto.OrderDTO;
import com.example.componentsplant.service.ClientService;
import com.example.componentsplant.dto.Message;
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

    @PostMapping(value = "/clients/1/orders", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDTO makeOrder (@RequestBody OrderDTO request) {
        log.info(request.toString());
        return clientService.makeOrder(request);
    }

    @PostMapping(value = "/clients/1/orders/{orderID}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Message changeOrder (@PathVariable("orderID") final Long orderID, @RequestBody OrderDTO request) {
        return clientService.changeOrder(orderID, request);
    }

    @DeleteMapping(value = "/clients/1/orders/{orderID}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Message deleteOrder (@PathVariable("orderID") final Long orderID) {
        return clientService.deleteOrder(orderID);
    }

    @GetMapping(value = "/clients/1", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<OrderDTO> watchOrderStory () {
        return clientService.watchOrder();
    }
}

