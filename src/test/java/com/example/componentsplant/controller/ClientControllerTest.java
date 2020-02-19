package com.example.componentsplant.controller;

import com.example.componentsplant.dto.Goods;
import com.example.componentsplant.dto.OrderDTO;
import com.example.componentsplant.dto.OrderItem;
import com.example.componentsplant.mapper.OrderDTOMapper;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ClientControllerTest extends AbstractControllerTest {

    @Autowired
    protected OrderDTOMapper orderDTOMapper;

    @Test
    public void testClientMakeOrderIsOk() throws Exception {
        // given
        BDDMockito.willReturn(orderDTOMapper.sourceToDestination(createOrderDTOInfo()))
                .given(orderRepository)
                .save(orderDTOMapper.sourceToDestination(createAnotherOrderDTOInfo()));
        // when
        mockMvc.perform(post("/clients/1/orders")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "  \"sum\" : 16000,\n" +
                        "  \"currency\" : \"BYR\",\n" +
                        "  \"clientID\" : 1,\n" +
                        "  \"goods\" : [\n {  " +
                             "  \"commodity\" : {\n" +
                                "  \"name\" : \"bottle\",\n" +
                                "  \"type\" : \"glassGoods\",\n" +
                                "  \"releaseCost\" : 100,\n" +
                                "  \"stockNumber\" : 111\n" +
                                "  }, \"quantity\" : 10\n" +
                                "  },\n" +
                                "{\n" +
                            "  \"commodity\" : {\n" +
                                "  \"name\" : \"barrel\",\n" +
                                "  \"type\" : \"woodGoods\",\n" +
                                "  \"releaseCost\" : 1000,\n" +
                                "  \"stockNumber\" : 207\n" +
                                "  }, \"quantity\" : 5\n" +
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

    @Test
    public void testClientUpdateOrderIsOk() throws Exception {
        // given
        BDDMockito.willReturn(orderDTOMapper.sourceToDestination(createOrderDTOInfo()))
                .given(orderRepository)
                .save(orderDTOMapper.sourceToDestination(createAnotherOrderDTOInfo()));
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
                        "  \"orderID\" : 123\n" +
                        "}"));
    }


    protected OrderDTO createOrderDTOInfo() {
        return OrderDTO.builder().orderID(123L).build();
    }

    protected OrderDTO createAnotherOrderDTOInfo() {
        final List<OrderItem> orderItemList = new ArrayList<>();
        orderItemList.add(OrderItem.builder().commodity(Goods.builder()
                .name("bottle")
                .type("glassGoods")
                .releaseCost(100L)
                .stockNumber(111L)
                .build()).quantity(10).build());
        orderItemList.add(OrderItem.builder().commodity(Goods.builder()
                .name("barrel")
                .type("woodGoods")
                .releaseCost(1000L)
                .stockNumber(207L)
                .build()).quantity(5).build());
        orderItemList.add(OrderItem.builder().commodity(Goods.builder()
                .name("dispencer")
                .type("metalGoods")
                .releaseCost(2500L)
                .stockNumber(319L)
                .build()).quantity(2).build());
        return OrderDTO.builder().sum(16000L).currency("BYR").clientID(1L).goods(orderItemList).build();
    }
}
