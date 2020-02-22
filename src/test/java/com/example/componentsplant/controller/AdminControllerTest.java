package com.example.componentsplant.controller;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AdminControllerTest extends AbstractControllerTest {

    @Test
    public void testAdminCreateGoodsIsOk() throws Exception {
        // given
        // when
        mockMvc.perform(post("/admin/goods/timberGoods")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "  \"name\" : \"barrel\",\n" +
                        "  \"type\" : \"timberGoods\",\n" +
                        "  \"description\" : \"forStout\",\n" +
                        "  \"releaseCost\" : 1000\n" +
                        "}"))
                // then
                .andExpect(status().isCreated())
                .andExpect(content().json("{\n" +
                        "  \"stockNumber\" : 321\n" +
                        "}"));
    }

    @Test
    public void testAdminWatchOrdersOnApprovementIsOk() throws Exception {
        // given
        // when
        mockMvc.perform(get("/admin/orders"))
                // then
                .andExpect(status().isOk())
                .andExpect(content().json("[\n" +
                        "{\n" +
                        "  \"bookingID\" : 43,\n" +
                        "  \"sum\" : 1230,\n" +
                        "  \"bookingCondition\" : \"ONAPPROVEMENT\"," +
                        "  \"clientID\" : 1" +
                        "},\n" +
                        "{\n" +
                        "  \"bookingID\" : 32,\n" +
                        "  \"sum\" : 1470,\n" +
                        "  \"bookingCondition\" : \"ONAPPROVEMENT\"," +
                        "  \"clientID\" : 2" +
                        "}\n" +
                        "]"));
    }

    @Test
    public void testAdminChangeGoodsPriceIsOk() throws Exception {
        // given
        // when
        mockMvc.perform(post("/admin/goods/timberGoods/321")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "  \"name\" : \"barrel\",\n" +
                        "  \"type\" : \"timberGoods\",\n" +
                        "  \"description\" : \"forStout\",\n" +
                        "  \"releaseCost\" : 900\n" +
                        "}"))
                // then
                .andExpect(status().isOk())
                .andExpect(content().json("{\n" +
                        "\"response\" : \"Price changed.\"\n" +
                        "}" ));
    }
}
