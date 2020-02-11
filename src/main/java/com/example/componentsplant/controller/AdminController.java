package com.example.componentsplant.controller;

import com.example.componentsplant.dto.Goods;
import com.example.componentsplant.dto.OrderDTO;
import com.example.componentsplant.service.AdminService;
import com.example.componentsplant.dto.Message;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping(value = "/admin")
public class AdminController {

    private final AdminService adminService;

    @PostMapping(value = "/goods/timberGoods/{storeID}")
    @ResponseStatus(HttpStatus.OK)
    public Message changePrice (@PathVariable ("storeID") final Long storeID, @RequestBody Goods request) {
        return adminService.changePrice(storeID, request);
    }

    @GetMapping(value = "/orders", produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    @ResponseStatus(HttpStatus.OK)
    public List<OrderDTO> watchOrdersOnApprovementGoods () {
        return adminService.watchOrdersOnApprovement();
    }

    @PostMapping(value = "/goods/timberGoods")
    @ResponseStatus(HttpStatus.CREATED)
    public Goods createGoods (@RequestBody Goods request) {
        return adminService.createGoods(request);
    }
}
