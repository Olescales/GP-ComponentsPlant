package com.example.componentsplant.service;

import com.example.componentsplant.dto.BookingDTO;
import com.example.componentsplant.dto.GoodsDTO;
import com.example.componentsplant.dto.GoodsNumberDTO;
import com.example.componentsplant.dto.Message;
import com.example.componentsplant.entity.BookingEntity;
import com.example.componentsplant.entity.GoodsEntity;
import com.example.componentsplant.exception.NoSuchBookings;
import com.example.componentsplant.mapper.BookingDTOMapper;
import com.example.componentsplant.mapper.GoodsMapper;
import com.example.componentsplant.repository.BookingRepository;
import com.example.componentsplant.repository.GoodsRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Data
@AllArgsConstructor
public class AdminService {

    private final GoodsMapper goodsMapper;
    private final BookingDTOMapper bookingDTOMapper;

    private final GoodsRepository goodsRepository;
    private final BookingRepository bookingRepository;

    public Message changePrice (final GoodsDTO goodsDTO) {
        goodsRepository.save(goodsMapper.sourceToDestination(goodsDTO));
        return Message.builder().response("The changes are saved.").build();
    }

    public List<BookingDTO> watchOrdersByCondition (final String condition) throws NoSuchBookings {
        final List<BookingEntity> bookingEntities = bookingRepository.findBookingEntitiesByCondition(condition);
        if (bookingEntities.isEmpty()) {
            throw new NoSuchBookings("There are no such bookings");
        }
        return bookingEntities.stream().map(bookingDTOMapper::destinationToSource).collect(Collectors.toList());
    }

    public GoodsNumberDTO createGoods (GoodsDTO goodsDTO) {
        final GoodsEntity goodsEntity = goodsMapper.sourceToDestination(goodsDTO);
        return GoodsNumberDTO.builder()
                .goodsID(goodsMapper.destinationToSource(goodsRepository.save(goodsEntity)).getGoodsID())
                .build();
    }


}
