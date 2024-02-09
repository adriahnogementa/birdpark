package com.birdpark.commands;

import java.time.LocalTime;

import an.awesome.pipelinr.Command;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EditOpeningTimeCommand implements Command<Boolean>{
    
    private Integer id;
    private Integer birdParkId;
    private String dayOfWeek;
    private LocalTime openingTime;
    private LocalTime closingTime;
}
