package com.birdpark.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class TicketPriceDto {

    private Integer id;
    private Integer birdParkId;
    private String ticketType;
    private BigDecimal price;

}
