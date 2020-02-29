package com.example.componentsplant.controller;

import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class DirectorControllerTest extends AbstractControllerTest {

    @Test
    public void directorWatchAmountOfOrdersPerFebruaryIsOk () throws Exception {
        mockMvc.perform(post("/director/orders")
                .param("orderdate", "2020-02-22"))
                //then
                .andExpect(status().isOk())
                .andExpect(content().json(
                        "{\n" +
                                "  \"totalSumOfOrders\" : 13385.25\n" +
                                "}"
                ));
    }

    @Test
    public void directorWatchProfitOfOrdersOfGlassGoodsPerFebruaryIsOk () throws Exception {
        mockMvc.perform(get("/director/orders/{glassGoods}"))
                //then
                .andExpect(status().isOk())
                .andExpect(content().json(
                        "{\n" +
                                "  \"totalSumOfOrders\" : 25000\n" +
                                "}"
                ));
    }
}
