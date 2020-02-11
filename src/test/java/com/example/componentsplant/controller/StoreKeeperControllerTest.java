package com.example.componentsplant.controller;

import org.junit.jupiter.api.Test;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

public class StoreKeeperControllerTest extends AbstractControllerTest {

    @Test
    public void StoreKeeperWatchOrdersController () throws Exception {
        mockMvc.perform(get("/storekeeper/orders"))
                //then
                .andExpect(status().isOk())
                .andExpect(content().json("[\n" +
                        "{\n" +
                            "  \"orderID\" : 41,\n" +
                            "  \"goodsList\" : [ {\n" +
                            "  \"goods\" : {\n" +
                                            "  \"storeID\" : 111\n" +
                                        "  },\"quantity\" : 10\n" +
                                             "  },\n" +
                            "  {\n" +
                            "  \"goods\" : {\n" +
                                        "  \"storeID\" : 207\n" +
                                         "  },\"quantity\" : 5\n" +
                            "  }\n" +
                            "  ],\n" +
                            "  \"orderCondition\" : \"ASSEMBLING\",\n" +
                            "  \"clientID\" : 41\n" +
                        "  },\n" +

                        "{\n" +
                        "  \"orderID\" : 23,\n" +
                        "  \"goodsList\" : [ {\n" +
                        "  \"goods\" : {\n" +
                        "  \"storeID\" : 117\n" +
                        "  },\"quantity\" : 11\n" +
                        "  },\n" +
                        "  {\n" +
                        "  \"goods\" : {\n" +
                        "  \"storeID\" : 189\n" +
                        "  },\"quantity\" : 4\n" +
                        "  }\n" +
                        "  ],\n" +
                        "  \"orderCondition\" : \"ASSEMBLING\",\n" +
                        "  \"clientID\" : 52\n" +
                        "  }\n" +
                        "]"));
    }
}