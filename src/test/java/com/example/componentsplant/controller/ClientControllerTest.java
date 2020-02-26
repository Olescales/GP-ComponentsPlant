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
        /*BDDMockito.willReturn(bookingDTOMapper.sourceToDestination(createOrderDTOInfo()))
                .given(bookingRepository)
                .save(bookingDTOMapper.sourceToDestination(createAnotherOrderDTOInfo()));*/
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
                        "  \"bookingID\" : 4\n" +
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
                        "  \"bookingID\" : 1,\n" +
                        "  \"sum\" : 379.45,\n" +
                        "  \"currency\" : \"BYN\",\n" +
                        "  \"orderdate\" : \"22.02.2020\",\n" +
                        "  \"wage\" : \"PREPAID\",\n" +
                        "  \"condition\" : \"SHIPPED\",\n" +
                        "  \"clientID\" : 1\n" +
                        "}\n" +
                        "]"));
    }

    @Test
    public void testClientUpdateOrderIsOk() throws Exception {
        // given
        /*BDDMockito.willReturn(bookingDTOMapper.sourceToDestination(createOrderDTOInfo()))
                .given(bookingRepository)
                .save(bookingDTOMapper.sourceToDestination(createAnotherOrderDTOInfo()));*/
        // when
        mockMvc.perform(post("/clients/1/orders/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "  \"sum\" : 19000,\n" +
                        "  \"currency\" : \"BYR\",\n" +
                        "  \"clientID\" : 1,\n" +
                        "  \"goods\" : [\n {  " +
                        "  \"commodity\" : {\n" +
                        "  \"name\" : \"bottle\",\n" +
                        "  \"type\" : \"glassGoods\",\n" +
                        "  \"releaseCost\" : 200,\n" +
                        "  \"stockNumber\" : 111\n" +
                        "  }, \"quantity\" : 10\n" +
                        "  },\n" +
                        "{\n" +
                        "  \"commodity\" : {\n" +
                        "  \"name\" : \"barrel\",\n" +
                        "  \"type\" : \"woodGoods\",\n" +
                        "  \"releaseCost\" : 1000,\n" +
                        "  \"stockNumber\" : 207\n" +
                        "  }, \"quantity\" : 6\n" +
                        "  },\n" +
                        "{\n" +
                        "  \"commodity\" : {\n" +
                        "  \"name\" : \"dispenser\",\n" +
                        "  \"type\" : \"metalGoods\",\n" +
                        "  \"releaseCost\" : 2500,\n" +
                        "  \"stockNumber\" : 319\n" +
                        "  }, \"quantity\" : 2\n" +
                        "  }\n" +
                        "] \n" +
                        "}"))
                // then
                .andExpect(status().isCreated())
                .andExpect(content().json("{\n" +
                        "  \"bookingID\" : 4\n" +
                        "}"));
    }
}
