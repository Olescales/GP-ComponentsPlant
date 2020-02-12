package com.example.componentsplant.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class OrderDTO {
    private Long sum;
    private String currency;
    @JsonFormat (pattern = "dd.MM.yyyy")
    private LocalDate dateOfTheOrder;
    private WageType wageType;
    private Long clientID;
    private OrderCondition orderCondition;
    private Long orderID;
    private List<OrderItem> goodsList;

}
