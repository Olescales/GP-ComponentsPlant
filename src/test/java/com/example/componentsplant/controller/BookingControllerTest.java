package com.example.componentsplant.controller;


import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class BookingControllerTest extends AbstractControllerTest {

    @Test
    public void testWatchOrderByIDIsOk() throws Exception {
        // given
        // when
        mockMvc.perform(get("/orders/1"))
                // then
                .andExpect(status().isOk())
                .andExpect(content().json(
                        "{\n" +
                                "  \"sum\" : 379.45,\n" +
                                "  \"currency\" : \"BYN\",\n" +
                                "  \"orderdate\" : \"2020-02-22\",\n" +
                                "  \"wage\" : \"PREPAID\",\n" +
                                "  \"condition\" : \"SHIPPED\",\n" +
                                "  \"clientID\" : 1\n" +
                                "}\n"));
    }
}
