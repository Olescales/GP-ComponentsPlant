package com.example.componentsplant.entity;

import com.example.componentsplant.dto.OrderCondition;
import com.example.componentsplant.dto.WageType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class OrderEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private Double sum;
    private String currency;
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate dateOfTheOrder;
    private WageType wageType;
    private Long clientID;
    private OrderCondition orderCondition;
    @OneToMany
    @JoinColumn
    private List<OrderItemEntity> goodsList;
}
