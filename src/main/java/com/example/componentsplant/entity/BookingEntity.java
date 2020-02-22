package com.example.componentsplant.entity;

import com.example.componentsplant.dto.BookingCondition;
import com.example.componentsplant.dto.WageType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity(name = "booking")

public class BookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "booking_id")
    private Long id;

    private Long sum;
    private String currency;
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate dateOfTheOrder;
    private WageType wageType;
    private BookingCondition bookingCondition;

    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn (name = "booking_item_id")
    private List<BookingItemEntity> bookingItemEntities;

    @ManyToOne ()
    @JoinColumn (name = "client_id", nullable = false)
    private ClientEntity client;

}
