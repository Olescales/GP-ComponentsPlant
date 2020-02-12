package com.example.componentsplant.controller;

import com.example.componentsplant.dto.OrdersAgregator;
import com.example.componentsplant.service.DirectorService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Data
@RestController
@RequestMapping (value = "/director/orders/prepaidOrders", produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
public class DirectorController {

    private final DirectorService directorService;

    @GetMapping (value = "/{glassGoods}")
    @ResponseStatus (HttpStatus.OK)
    public OrdersAgregator watchProfitGlassGoods (@PathVariable ("glassGoods") final String glassGoods) {
        return directorService.watchProfitGlassGoods(glassGoods);
    }

    @GetMapping (value = "")
    @ResponseStatus (HttpStatus.OK)
    public OrdersAgregator watchTotalSumOfOrders () {
        return directorService.watchTotalSumOfOrders();
    }
}
