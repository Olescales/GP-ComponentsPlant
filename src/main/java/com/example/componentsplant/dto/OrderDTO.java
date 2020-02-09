package com.example.componentsplant.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.util.HashMap;

@Data
public class OrderDTO {
    private HashMap<String, Integer> goodsMap;
    private Long sum;
    private String currency;
    @JsonFormat (pattern = "dd.MM.yyyy")
    private LocalDate dateOfTheOrder;
    private WageType wageType;
    private Long clientId;
    private OrderCondition orderCondition;
}
