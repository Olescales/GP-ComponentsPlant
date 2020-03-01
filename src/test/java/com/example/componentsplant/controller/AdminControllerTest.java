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
                        "  \"netcost\" : 750,\n" +
                        "  \"releasecost\" : 1000,\n" +
                        "  \"stocknumber\" : 20001\n" +
                        "}"))
                // then
                .andExpect(status().isCreated())
                .andExpect(content().json("{\n" +
                        "  \"goodsID\" : 5\n" +
                        "}"));
    }

    @Test()
    public void testAdminWatchOrdersOnApprovementIsOk() throws Exception {
        // given
        // when
        mockMvc.perform(get("/admin/orders")
                .param("condition", "ONAPPROVEMENT"))
                // then
                .andExpect(status().isOk())
                .andExpect(content().json("[\n" +
                        "{\n" +
                        "  \"sum\" : 3735.46,\n" +
                        "  \"currency\" : \"BYN\",\n" +
                        "  \"orderdate\" : \"2020-02-27\",\n" +
                        "  \"wage\" : \"PREPAID\",\n" +
                        "  \"condition\" : \"ONAPPROVEMENT\",\n" +
                        "  \"bookingID\" : 4\n" +
                        "}" +
                        "]"));
    }

    @Test
    public void testAdminChangeGoodsPriceIsOk() throws Exception {
        // given
        // when
        mockMvc.perform(post("/admin/goods/321")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "  \"name\" : \"barrel\",\n" +
                        "  \"type\" : \"timberGoods\",\n" +
                        "  \"description\" : \"forStout\",\n" +
                        "  \"netcost\" : 750,\n" +
                        "  \"releasecost\" : 1100,\n" +
                        "  \"stocknumber\" : 20001\n" +
                        "}"))
                // then
                .andExpect(status().isOk())
                .andExpect(content().json("{\n" +
                        "\"response\" : \"The changes are saved.\"\n" +
                        "}"));
    }
}
