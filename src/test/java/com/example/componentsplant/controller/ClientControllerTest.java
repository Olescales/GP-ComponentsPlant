package com.example.componentsplant.controller;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ClientControllerTest extends AbstractControllerTest {

    @Test
    public void testClientMakeOrderIsOk() throws Exception {
        // given
        // when
        mockMvc.perform(post("/clients/1/orders")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "  \"sum\" : 16000,\n" +
                        "  \"currency\" : \"BYR\",\n" +
                        "  \"clientId\" : 1,\n" +
                        "  \"goodsMap\" : [\n  " +
                                "{\n" +
                                "  \"name\" : \"bottle\",\n" +
                                "  \"type\" : \"glassGoods\",\n" +
                                "  \"releaseCost\" : 100\n" +
                                "  } : 10,\n" +
                                "{\n" +
                                "    \"name\" : \"barrel\",\n" +
                                "  \"type\" : \"woodenGoods\",\n" +
                                "  \"releaseCost\" : 1000\n" +
                                "  } : 5,\n" +
                                "{\n" +
                                "  \"name\" : \"dispenser\",\n" +
                                "  \"type\" : \"metalGoods\",\n" +
                                "  \"releaseCost\" : 2500\n" +
                                "  } : 2\n" +
                            "] \n" +
                        "}"))
                // then
                .andExpect(status().isCreated())
                .andExpect(content().json("{\n" +
                        "  \"orderID\" : 123\n" +
                        "}"));
    }

    @Test
    public void testClientDeleteOrderIsOk() throws Exception {
        // given
        // when
        mockMvc.perform(delete("/clients/1/orders/1"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\n" +
                        "  \"response\" : \"Заказ удалён!\"\n" +
                        "}"));
    }

    @Test
    public void testClientWatchOrdersStoryIsOk() throws Exception {
        // given
        // when
        mockMvc.perform(get("/clients/1"))
                // then
                .andExpect(status().isOk())
                .andExpect(content().json("[\n" +
                        "{\n" +
                        "  \"orderID\" : 1,\n" +
                        "  \"sum\" : 1000,\n" +
                        "  \"orderCondition\" : \"SHIPPED\"\n" +
                        "},\n" +
                        "{\n" +
                        "  \"orderID\" : 2,\n" +
                        "  \"sum\" : 2500,\n" +
                        "  \"orderCondition\" : \"READYFORSHIPMENT\"\n" +
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
