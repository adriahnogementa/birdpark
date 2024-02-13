package com.birdpark.dto;

import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OpeningTimeDto {

    private Integer id;
    private Integer birdParkId;
    private String dayOfWeek;
    private LocalTime openingTime;
    private LocalTime closingTime;
}
