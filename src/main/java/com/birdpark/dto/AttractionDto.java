package com.birdpark.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class AttractionDto {

    private Integer id;
    private String attractionName;
    private byte[] logo;
    private String description;
    private Integer durationInMinutes;
    private Integer tourId;
}