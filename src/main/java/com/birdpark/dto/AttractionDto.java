package com.birdpark.dto;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class AttractionDto {

    private Integer attraction_id;
    private String attractionName;
    private byte[] logo;
    private String description;
    private Integer durationInMinutes;
    private Integer tourOrder; 
    private List<String> tags;
    private List<String> tour;

    public AttractionDto() {
    }

    public AttractionDto(Integer attraction_id, String attractionName, Integer tourOrder) {
        this.attraction_id = attraction_id;
        this.attractionName = attractionName;
        this.tourOrder = tourOrder;
    }

    public AttractionDto(String attractionName) {
        this.attractionName = attractionName;
    }
}