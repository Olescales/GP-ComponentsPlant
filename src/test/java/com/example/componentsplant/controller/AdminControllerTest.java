package com.example.componentsplant.controller;

import com.example.componentsplant.dto.BookingDTO;
import com.example.componentsplant.dto.GoodsDTO;
import com.example.componentsplant.entity.BookingEntity;
import com.example.componentsplant.mapper.BookingDTOMapper;
import com.example.componentsplant.mapper.GoodsMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.willReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AdminControllerTest extends AbstractControllerTest {
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private BookingDTOMapper bookingDTOMapper;

    @Test
    public void testAdminCreateGoodsIsOk() throws Exception {

        // given
        final GoodsDTO goodsDTO = new GoodsDTO();
        goodsDTO.setName("barrel");
        goodsDTO.setDescription("forStout");
        goodsDTO.setReleasecost(1000d);
        goodsDTO.setStocknumber(20001L);
        goodsDTO.setNetcost(750d);
        goodsDTO.setType("timberGoods");

        willReturn(goodsMapper.sourceToDestination(GoodsDTO.builder().goodsID(5L).build()))
                .given(goodsRepository)
                .save(goodsMapper.sourceToDestination(goodsDTO));
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
        final BookingDTO bookingDTO = BookingDTO.builder()
                .sum(3735.46)
                .currency("BYN")
                .orderdate(LocalDate.parse("2020-02-27"))
                .wage("PREPAID")
                .condition("ONAPPROVEMENT")
                .bookingID(4L).build();
        final List<BookingEntity> bookingEntityList = new ArrayList<>();
        bookingEntityList.add(bookingDTOMapper.sourceToDestination(bookingDTO));
        willReturn(bookingEntityList)
                .given(bookingRepository)
                .findBookingEntitiesByCondition("ONAPPROVEMENT");
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
        final GoodsDTO goodsDTO = new GoodsDTO();
        goodsDTO.setName("barrel");
        goodsDTO.setGoodsID(5L);
        goodsDTO.setDescription("forStout");
        goodsDTO.setNetcost(750d);
        goodsDTO.setReleasecost(1100d);
        goodsDTO.setStocknumber(20001L);
        goodsDTO.setType("timberGoods");

        willReturn(goodsMapper.sourceToDestination(goodsDTO)).given(goodsRepository).save(goodsMapper.sourceToDestination(goodsDTO));
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
