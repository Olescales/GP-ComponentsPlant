package com.example.componentsplant.service;

import com.example.componentsplant.dto.BookingDTO;
import com.example.componentsplant.dto.BookingNumberDTO;
import com.example.componentsplant.dto.GoodsDTO;
import com.example.componentsplant.dto.Message;
import com.example.componentsplant.entity.BookingEntity;
import com.example.componentsplant.entity.BookingItemEntity;
import com.example.componentsplant.entity.GoodsEntity;
import com.example.componentsplant.entity.WareHouseEntity;
import com.example.componentsplant.exception.NotEnoughGoodsInTheStock;
import com.example.componentsplant.mapper.BookingDTOMapper;
import com.example.componentsplant.mapper.BookingItemMapper;
import com.example.componentsplant.mapper.GoodsMapper;
import com.example.componentsplant.repository.BookingRepository;
import com.example.componentsplant.repository.ClientRepository;
import com.example.componentsplant.repository.GoodsRepository;
import com.example.componentsplant.repository.WareHouseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClientService {

    private final BookingRepository bookingRepository;
    private final WareHouseRepository wareHouseRepository;
    private final GoodsRepository goodsRepository;
    private final GoodsMapper goodsMapper;
    private final ClientRepository clientRepository;

    private final BookingDTOMapper bookingDTOMapper;
    private final BookingItemMapper bookingItemMapper;

    public BookingNumberDTO makeOrder(final Long clientID, final BookingDTO request) throws NotEnoughGoodsInTheStock {
        final BookingEntity bookingEntity = bookingDTOMapper.sourceToDestination(request);
        bookingEntity.setClient(clientRepository.getClientEntityById(clientID));

        final List<BookingItemEntity> bookingItemEntityList =
            request.getGoods().stream().map(bookingItemMapper::sourceToDestination).collect(Collectors.toList());
        for (final BookingItemEntity bookingItemEntity : bookingItemEntityList) {
            Long goodsID = bookingItemEntity.getCommodity().getId();
            Integer quantity = bookingItemEntity.getQuantity();
            if (!checkGoodsAvailability(goodsID, quantity)) {
                final GoodsEntity goodsEntity = goodsRepository.getGoodsEntityById(goodsID);
                throw new NotEnoughGoodsInTheStock("Insufficient reserve of goods: " + goodsEntity.getName());
            }
            final GoodsEntity goodsEntity = goodsRepository.getGoodsEntityById(goodsID);
            bookingItemEntity.setCommodity(goodsEntity);
        }
        bookingEntity.setBookingItemEntities(bookingItemEntityList);

        bookingEntity.getBookingItemEntities().forEach(
            bookingItemEntity -> bookingItemEntity.setBookingEntity(bookingEntity));

        return BookingNumberDTO.builder()
            .bookingID(bookingRepository.save(bookingEntity).getId())
            .build();
    }

    public boolean checkGoodsAvailability(final Long goodsID, final Integer quantity) {
        final WareHouseEntity wareHouseEntity = wareHouseRepository.getWareHouseEntityByGoodsEntity_Id(goodsID);
        final Long reserve = wareHouseEntity.getReserve();
        return quantity <= reserve;
    }


    public Message deleteOrder(final Long bookingID) {
        bookingRepository.deleteById(bookingID);
        return Message.builder().response("Order deleted!").build();
    }

    public Message changeOrder(final BookingDTO request) {
        bookingRepository.save(bookingDTOMapper.sourceToDestination(request));
        return Message.builder().response("Order updated!").build();
    }

    public List<BookingDTO> watchOrderStory(final Long clientID) {
        final List<BookingEntity> bookingEntities = bookingRepository.findBookingEntitiesByClient_Id(clientID);
        return bookingEntities.stream().map(bookingDTOMapper::destinationToSource).collect(Collectors.toList());
    }

    public List<GoodsDTO> showGoods() {
        return goodsRepository.findAll().stream().map(goodsMapper::destinationToSource).collect(Collectors.toList());
    }
}
