package com.birdpark.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AttractionForUserDto {


    private Integer id;
    private String attractionName;
    private String description;
    private byte[] logo;
    private List<String> tags;
    private String tour;
}