package com.example.componentsplant.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity(name = "booking")

public class BookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY  )
    private Long id;

    private Double sum;
    private String currency;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate orderdate;
    private String wage;
    private String condition;

    @OneToMany (mappedBy = "bookingEntity", cascade = CascadeType.ALL)
    private List<BookingItemEntity> bookingItemEntities;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "client_id", nullable = false)
    private ClientEntity client;

}
