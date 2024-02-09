package com.birdpark.queries;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.birdpark.dto.OpeningTimeDto;
import com.birdpark.entity.OpeningTime;
import com.birdpark.repository.OpeningTimeRepository;

import an.awesome.pipelinr.Command;

public class OpeningTimeQuery implements Command<List<OpeningTimeDto>> {

@Autowired
OpeningTimeRepository repository;

    public List<OpeningTimeDto> execute(){
        List<OpeningTime> openingTimeList = repository.findAll();

        return openingTimeList.stream().map(openingTime -> mapToDto(openingTime)).toList();
       
    }

    private OpeningTimeDto mapToDto(OpeningTime openingTime) {
        
        return new OpeningTimeDto(openingTime.getId(), openingTime.getBirdParkId(), openingTime.getDayOfWeek(), openingTime.getOpeningTime(), openingTime.getClosingTime());
    }
    
}
