package com.example.componentsplant.controller;

import com.example.componentsplant.mapper.BookingDTOMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ClientControllerTest extends AbstractControllerTest {

    @Autowired
    protected BookingDTOMapper bookingDTOMapper;

    @Test
    public void testClientMakeOrderIsOk() throws Exception {
        // given
        // when
        mockMvc.perform(post("/clients/1/orders")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "  \"sum\" : 16000,\n" +
                        "  \"currency\" : \"BYR\",\n" +
                        "  \"orderdate\" : \"2020-02-22\",\n" +
                        "  \"wage\" : \"PREPAID\",\n" +
                        "  \"condition\" : \"ONAPPROVEMENT\",\n" +
                        "  \"goods\" : [\n {  " +
                        "  \"goodsID\" : 1,\n" +
                        "   \"quantity\" : 10\n" +
                        "  },\n" +
                        "{\n" +
                        "   \"goodsID\" : 3,\n" +
                        "   \"quantity\" : 5\n" +
                        "  },\n" +
                        "{\n" +
                        "   \"goodsID\" : 4,\n" +
                        "   \"quantity\" : 2\n" +
                        "  }\n" +
                        "] \n" +
                        "}"))
                // then
                .andExpect(status().isCreated())
                .andExpect(content().json("{\n" +
                        "  \"bookingID\" : 5\n" +
                        "}"));
    }

    @Test
    public void testClientDeleteOrderIsOk() throws Exception {
        // given
        // when
        mockMvc.perform(delete("/clients/1/orders/1"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\n" +
                        "  \"response\" : \"Order deleted!\"\n" +
                        "}"));
    }

    @Test
    public void testClientWatchOrdersStoryIsOk() throws Exception {
        // given
        // when
        mockMvc.perform(get("/clients/2"))
                // then
                .andExpect(status().isOk())
                .andExpect(content().json("[\n" +
                        "{\n" +
                        "  \"sum\" : 13005.80,\n" +
                        "  \"currency\" : \"BYN\",\n" +
                        "  \"orderdate\" : \"2020-02-22\",\n" +
                        "  \"wage\" : \"POSTPONEMENT\",\n" +
                        "  \"condition\" : \"SHIPPED\",\n" +
                        "  \"bookingID\" : 2\n" +
                        "},\n" +
                        "{\n" +
                        "  \"sum\" : 7230.82,\n" +
                        "  \"currency\" : \"BYN\",\n" +
                        "  \"orderdate\" : \"2020-02-23\",\n" +
                        "  \"wage\" : \"PREPAID\",\n" +
                        "  \"condition\" : \"READYFORSHIPMENT\",\n" +
                        "  \"bookingID\" : 3\n" +
                        "},\n" +
                        "{\n" +
                        "  \"sum\" : 3735.46,\n" +
                        "  \"currency\" : \"BYN\",\n" +
                        "  \"orderdate\" : \"2020-02-27\",\n" +
                        "  \"wage\" : \"PREPAID\",\n" +
                        "  \"condition\" : \"ONAPPROVEMENT\",\n" +
                        "  \"bookingID\" : 4\n" +
                        "}\n" +
                        "]"));
    }

    @Test
    public void testClientUpdateOrderIsOk() throws Exception {
        // given
        // when
        mockMvc.perform(post("/clients/1/orders/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "  \"sum\" : 16000,\n" +
                        "  \"currency\" : \"BYR\",\n" +
                        "  \"orderdate\" : \"2020-02-22\",\n" +
                        "  \"wage\" : \"POSTPONEMENT\",\n" +
                        "  \"condition\" : \"ONAPPROVEMENT\",\n" +
                        "  \"goods\" : [\n {  " +
                        "  \"goodsID\" : 1,\n" +
                        "   \"quantity\" : 10\n" +
                        "  },\n" +
                        "{\n" +
                        "   \"goodsID\" : 3,\n" +
                        "   \"quantity\" : 5\n" +
                        "  },\n" +
                        "{\n" +
                        "   \"goodsID\" : 4,\n" +
                        "   \"quantity\" : 2\n" +
                        "  }\n" +
                        "] \n" +
                        "}"))
                // then
                .andExpect(status().isCreated())
                .andExpect(content().json("{\n" +
                        "  \"response\" : \"Order updated!\"\n" +
                        "}"));
    }
}
