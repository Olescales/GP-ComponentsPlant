package com.example.componentsplant.service;

import com.example.componentsplant.dto.BookingDTO;
import com.example.componentsplant.dto.BookingItemDTO;
import com.example.componentsplant.dto.BookingNumberDTO;
import com.example.componentsplant.dto.Message;
import com.example.componentsplant.entity.BookingEntity;
import com.example.componentsplant.entity.GoodsEntity;
import com.example.componentsplant.entity.WareHouseEntity;
import com.example.componentsplant.exception.NotEnoughGoodsInStock;
import com.example.componentsplant.mapper.BookingDTOMapper;
import com.example.componentsplant.repository.BookingRepository;
import com.example.componentsplant.repository.GoodsRepository;
import com.example.componentsplant.repository.WareHouseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ClientService {

    private final BookingRepository bookingRepository;
    private final WareHouseRepository wareHouseRepository;
    private final GoodsRepository goodsRepository;

    private final BookingDTOMapper bookingDTOMapper;

    public BookingNumberDTO makeOrder(final Long clientID, final BookingDTO request) throws NotEnoughGoodsInStock {
        request.setClientID(clientID);
        System.out.println(request);
        List<BookingItemDTO> bookingItemDTOS = request.getGoods();
        for (BookingItemDTO items: bookingItemDTOS) {
            Long goodsID = items.getGoodsID();
            Integer quantity = items.getQuantity();
            if (!checkStockAvailability(goodsID,quantity)) {
                GoodsEntity goodsEntity = goodsRepository.getGoodsEntityById(goodsID);
                throw new NotEnoughGoodsInStock("Insufficient reserve of goods: " + goodsEntity.getName());
            }
        }
        final BookingEntity bookingEntity = bookingDTOMapper.sourceToDestination(request);
        return BookingNumberDTO.builder()
                .bookingID(bookingRepository.save(bookingEntity).getId())
                .build();
    }


    public boolean checkStockAvailability (final Long goodsID, final Integer quantity) {
        WareHouseEntity wareHouseEntity = wareHouseRepository.getWareHouseEntityByGoodsEntity_Id(goodsID);
        Long reserve = wareHouseEntity.getReserve();
        return quantity < reserve;
    }


    public Message deleteOrder(final Long bookingID) {
        return Message.builder().response("Заказ удалён!").build();
    }

    public Message changeOrder(final Long bookingID, final BookingDTO bookingDTO) {
        return Message.builder().response("Заказ обновлён").build();
    }

    public List<BookingDTO> watchOrder(final Long clientID) {

        final List<BookingEntity> bookingEntities = bookingRepository.findBookingEntitiesByClient_Id(clientID);
        final List<BookingDTO> bookingDTOList = new ArrayList<>();
        for (BookingEntity entity : bookingEntities) {
            bookingDTOList.add(bookingDTOMapper.destinationToSource(entity));
        }
        return bookingDTOList;
    }
}
