package com.example.componentsplant.controller;

import com.example.componentsplant.dto.BookingDTO;
import com.example.componentsplant.dto.GoodsDTO;
import com.example.componentsplant.dto.GoodsNumberDTO;
import com.example.componentsplant.dto.Message;
import com.example.componentsplant.exception.NoSuchBookings;
import com.example.componentsplant.service.AdminService;
import lombok.Data;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@Log
@RequestMapping(value = "/admin")
public class AdminController {

    private final AdminService adminService;

    @PostMapping(value = "/goods/{goodsID}")
    @ResponseStatus(HttpStatus.OK)
    public Message changePrice (@PathVariable ("goodsID") final Long goodsID, @RequestBody GoodsDTO request) {
        request.setGoodsID(goodsID);
        return adminService.changePrice(request);
    }

    @GetMapping(value = "/orders", produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    @ResponseStatus(HttpStatus.OK)
    public List<BookingDTO> watchOrdersByCondition (@RequestParam(value="condition",required = false) final String condition) throws NoSuchBookings {
        return adminService.watchOrdersByCondition(condition);
    }

    @PostMapping(value = "/goods")
    @ResponseStatus(HttpStatus.CREATED)
    public GoodsNumberDTO createGoods (@RequestBody GoodsDTO request) {
        log.info(request.toString());
        return adminService.createGoods(request);
    }
}
