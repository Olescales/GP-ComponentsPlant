package com.example.componentsplant.controller;

import com.example.componentsplant.dto.BookingAggregator;
import com.example.componentsplant.dto.BookingDTO;
import com.example.componentsplant.service.DirectorService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Data
@RestController
@RequestMapping(value = "/director/orders", produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
public class DirectorController {

    private final DirectorService directorService;

    @GetMapping(value = "/{glassGoods}")
    @ResponseStatus(HttpStatus.OK)
    public BookingAggregator watchProfitGlassGoods(@PathVariable("glassGoods") final String glassGoods, @RequestBody final BookingDTO request) {
        return directorService.watchProfitGlassGoods(glassGoods, request);
    }

    @PostMapping(value = "")
    @ResponseStatus(HttpStatus.OK)
    public BookingAggregator watchTotalSumOfOrders(@RequestParam(value="orderdate",required = false) final String orderdate) {
        return directorService.watchTotalSumOfOrders(orderdate);
    }
}
