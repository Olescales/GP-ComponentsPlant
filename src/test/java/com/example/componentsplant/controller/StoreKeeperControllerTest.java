package com.example.componentsplant.controller;

import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class StoreKeeperControllerTest extends AbstractControllerTest {

    @Test
    public void StoreKeeperWatchOrdersController () throws Exception {
        mockMvc.perform(post("/storekeeper/orders")
                .param("condition", "ONAPPROVEMENT"))
                //then
                .andExpect(status().isOk())
                .andExpect(content().json("[\n" +
                        "{\n" +
                        "  \"orderdate\" : \"2020-02-27\",\n" +
                        "  \"clientID\"  : 2,\n" +
                        "  \"condition\" : \"ONAPPROVEMENT\",\n" +
                        "  \"bookingID\" : 4\n" +
                        "}\n" +
                        "]"));
    }
}
