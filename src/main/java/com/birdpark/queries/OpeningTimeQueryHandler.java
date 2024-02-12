package com.birdpark.queries;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.birdpark.dto.OpeningTimeDto;
import com.birdpark.entity.OpeningTime;
import com.birdpark.repository.OpeningTimeRepository;

import an.awesome.pipelinr.Command;

@Component
public class OpeningTimeQueryHandler implements Command.Handler<OpeningTimeQuery, List<OpeningTimeDto>>{

@Autowired
OpeningTimeRepository repository;

    @Override
    public List<OpeningTimeDto> handle(OpeningTimeQuery command) {
       
        List<OpeningTime> openingTimeList = repository.findByBirdId(command.getBird_park_id());

        if (!openingTimeList.isEmpty()) {
            return openingTimeList.stream().map(openingTime -> mapToDto(openingTime)).toList();
        }else {
            throw new RuntimeException("Opening Time not found");
        }
    }

    private OpeningTimeDto mapToDto(OpeningTime openingTime) {
        return new OpeningTimeDto(openingTime.getId(), openingTime.getBirdParkId(), openingTime.getDayOfWeek(), openingTime.getOpeningTime(), openingTime.getClosingTime());
    }
    

}
