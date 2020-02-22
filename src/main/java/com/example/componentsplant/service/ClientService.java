package com.example.componentsplant.service;

import com.example.componentsplant.dto.BookingCondition;
import com.example.componentsplant.dto.BookingDTO;
import com.example.componentsplant.dto.Message;
import com.example.componentsplant.entity.BookingEntity;
import com.example.componentsplant.mapper.BookingDTOMapper;
import com.example.componentsplant.repository.BookingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ClientService {

    private final BookingDTOMapper bookingDTOMapper;
    private final BookingRepository bookingRepository;

    public BookingDTO makeOrder (final BookingDTO request) {
        final BookingEntity bookingEntity = bookingDTOMapper.sourceToDestination(request);
        return bookingDTOMapper.destinationToSource(bookingRepository.save(bookingEntity));
    }

    public Message deleteOrder (final Long bookingID) {
        return Message.builder().response("Заказ удалён!").build();
    }

    public Message changeOrder (final Long bookingID, final  BookingDTO bookingDTO) {
        return Message.builder().response("Заказ обновлён").build();
    }

    public List<BookingDTO> watchOrder () {
        final List<BookingDTO> bookingDTOList = new ArrayList<>();
        bookingDTOList.add(BookingDTO.builder().bookingID(1L).sum(1000L).bookingCondition(BookingCondition.SHIPPED).build());
        bookingDTOList.add(BookingDTO.builder().bookingID(2L).sum(2500L).bookingCondition(BookingCondition.READYFORSHIPMENT).build());
        return bookingDTOList;
    }
}
