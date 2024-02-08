package com.birdpark.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ParkInformationDto{

    private String parkName;
    private String parkLocation;
    private String parkDescription;
}
