package com.example.componentsplant.controller;

import com.example.componentsplant.dto.BookingAggregator;
import com.example.componentsplant.dto.GoodsDTO;
import com.example.componentsplant.service.DirectorService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping(value = "/director/orders", produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
public class DirectorController {

    private final DirectorService directorService;

    @GetMapping(value = "")
    @ResponseStatus(HttpStatus.OK)
    public List<GoodsDTO> watchAssortmentOfGoodsByType(@RequestParam(value="type",required = false) final String type) {
        return directorService.watchAssortmentOfGoodsByType(type);
    }

    @PostMapping(value = "")
    @ResponseStatus(HttpStatus.OK)
    public BookingAggregator watchTotalSumOfOrders(@RequestParam(value="orderdate",required = false) final String orderdate) {
        return directorService.watchTotalSumOfOrders(orderdate);
    }
}
