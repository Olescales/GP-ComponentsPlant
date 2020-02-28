package com.example.componentsplant.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class BookingDTO {
    private Double sum;
    private String currency;
    @JsonFormat (pattern = "yyyy-MM-dd")
    private LocalDate orderdate;
    private String wage;
    private Long clientID;
    private String condition;
    private Long bookingID;
    private List<BookingItemDTO> goods;

}
