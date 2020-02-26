package com.example.componentsplant.service;

import com.example.componentsplant.dto.BookingDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StoreKeeperService {

    public List<BookingDTO> watchOrders() {
        List<BookingDTO> orderDTOList = new ArrayList<>();
        return orderDTOList;

    }
}
