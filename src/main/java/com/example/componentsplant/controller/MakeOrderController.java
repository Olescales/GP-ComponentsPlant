package com.example.componentsplant.controller;

import com.example.componentsplant.dto.MakeOrderResponse;
import com.example.componentsplant.dto.OrderDTO;
import com.example.componentsplant.service.MakeOrderService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Data
@RestController
@RequestMapping (value = "/client", produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
public class MakeOrderController {

    private final MakeOrderService makeOrderService;

    @PostMapping(value = "/order", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public MakeOrderResponse makeOrder (@RequestBody OrderDTO request) {
        return makeOrderService.makeOrder(request);
    }
}
