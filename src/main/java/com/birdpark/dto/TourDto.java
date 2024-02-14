package com.birdpark.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalTime;

@Setter
@Getter
@AllArgsConstructor
public class TourDto {

    private Integer tourId;
    private byte[] logo;
    private BigDecimal price;
    private Integer durationInMinutes;
    private String name;
    private LocalTime beginTime;
    private LocalTime endTime;

}
