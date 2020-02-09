package com.example.componentsplant.controller;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class MakeOrderControllerTest extends AbstractControllerTest {

    @Test
    public void testClientMakeOrderIsOk() throws Exception {
        // given
        // when
        mockMvc.perform(post("/client/order")
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
                        "  \"order\" : 123\n" +
                        "}"));
    }
}
