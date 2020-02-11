package com.example.componentsplant.controller;

import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class WatchOrdersControllerTest extends AbstractControllerTest {

    @Test
    public void testWatchOrdersIsOk() throws Exception {
        // given
        // when
        mockMvc.perform(get("/client/1/myOrders?date=02-2020")
                        .header("clientId", 1))
                // then
                .andExpect(status().isOk())
                .andExpect(content().json("[\n" +
                        "{\n" +
                        "  \"id\" : 1,\n" +
                        "  \"sum\" : 1000,\n" +
                        "  \"condition\" : shipped\n" +
                        "},\n" +
                        "{\n" +
                        "  \"id\" : 2,\n" +
                        "  \"sum\" : 2500,\n" +
                        "  \"condition\" : \"readyForShipment\"\n" +
                        "}\n" +
                        "]"));
    }
}
