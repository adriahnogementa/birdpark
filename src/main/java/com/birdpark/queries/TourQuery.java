package com.birdpark.queries;

import java.util.List;

import com.birdpark.dto.TourDto;
import an.awesome.pipelinr.Command;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TourQuery implements Command<List<TourDto>>{
    
}
