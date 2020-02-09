package com.example.componentsplant.service;

        import com.example.componentsplant.dto.MakeOrderResponse;
        import com.example.componentsplant.dto.OrderDTO;
        import org.springframework.stereotype.Service;

@Service
public class MakeOrderService {
    public MakeOrderResponse makeOrder (OrderDTO request) {
        return MakeOrderResponse.builder().id(123L).build();
    }
}
