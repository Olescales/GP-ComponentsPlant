package com.example.componentsplant.controller;

import com.example.componentsplant.security.UserRole;
import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class DirectorControllerTest extends AbstractControllerTest {

    @Test
    public void directorWatchAmountOfOrdersPerFebruaryIsOk () throws Exception {
        mockMvc.perform(get("/director/orders/prepaidOrders").header(UserRole.DIRECTOR.name(),UserRole.DIRECTOR.name()))
                //then
                .andExpect(status().isOk())
                .andExpect(content().json(
                        "{\n" +
                                "  \"totalSumOfOrders\" : 123456\n" +
                                "}"
                ));
    }

    @Test
    public void directorWatchProfitOfOrdersOfGlassGoodsPerFebruaryIsOk () throws Exception {
        mockMvc.perform(get("/director/orders/prepaidOrders/all"))
                //then
                .andExpect(status().isOk())
                .andExpect(content().json(
                        "{\n" +
                                "  \"totalSumOfProfit\" : 25000\n" +
                                "}"
                ));
    }
}
