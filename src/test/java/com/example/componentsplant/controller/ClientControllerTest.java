package com.example.componentsplant.controller;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ClientControllerTest extends AbstractControllerTest {

    /*@Test
    public void testClientMakeOrderIsOk() throws Exception {
        // given
        // when
        mockMvc.perform(post("/clients/1/orders")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "  \"goodsMap\" : {\n" +
                        "  \"345\" : 10,\n" +
                        "  \"232\" : 5,\n" +
                        "  \"122\" : 2,\n" +
                        "  },\n" +
                        "  \"sum\" : 16000,\n" +
                        "  \"currency\" : \"BYR\",\n" +
                        "  \"clientId\" : 1\n" +
                        "}"))
                // then
                .andExpect(status().isCreated())
                .andExpect(content().json("{\n" +
                        "  \"orderID\" : 123\n" +
                        "}"));
    }*/

    /*@Test
    public void testClientDeleteOrderIsOk() throws Exception {
        // given
        // when
        mockMvc.perform(post("/clients/1/orders")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "  \"goodsMap\" : {\n" +
                        "  \"345\" : 10,\n" +
                        "  \"232\" : 5,\n" +
                        "  \"122\" : 2,\n" +
                        "  },\n" +
                        "  \"sum\" : 16000,\n" +
                        "  \"currency\" : \"BYR\",\n" +
                        "  \"clientId\" : 1\n" +
                        "}"))
                // then
                .andExpect(status().isCreated())
                .andExpect(content().json("{\n" +
                        "  \"orderID\" : 123\n" +
                        "}"));
    }*/

    @Test
    public void testClientWatchOrdersIsOk() throws Exception {
        // given
        // when
        mockMvc.perform(get("/clients/1"))
                // then
                .andExpect(status().isOk())
                .andExpect(content().json("[\n" +
                        "{\n" +
                        "  \"orderID\" : 1,\n" +
                        "  \"sum\" : 1000,\n" +
                        "  \"condition\" : \"shipped\"\n" +
                        "},\n" +
                        "{\n" +
                        "  \"orderID\" : 2,\n" +
                        "  \"sum\" : 2500,\n" +
                        "  \"condition\" : \"readyForShipment\"\n" +
                        "}\n" +
                        "]"));
    }

    /*@Test
    public void testClientUpdateOrderIsOk() throws Exception {
        // given
        // when
        mockMvc.perform(post("/clients/1/orders")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "  \"goodsMap\" : {\n" +
                        "  \"345\" : 10,\n" +
                        "  \"232\" : 5,\n" +
                        "  \"122\" : 2,\n" +
                        "  },\n" +
                        "  \"sum\" : 16000,\n" +
                        "  \"currency\" : \"BYR\",\n" +
                        "  \"clientId\" : 1\n" +
                        "}"))
                // then
                .andExpect(status().isCreated())
                .andExpect(content().json("{\n" +
                        "  \"orderID\" : 123\n" +
                        "}"));
    }*/
}
