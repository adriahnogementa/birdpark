package com.birdpark.dto;

import java.util.List;


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
    private List<String> tags;
    private List<String> tour;
}