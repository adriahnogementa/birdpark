package com.birdpark.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.birdpark.entity.OpeningTime;
import com.birdpark.repository.OpeningTimeRepository;

import an.awesome.pipelinr.Command;

@Component
public class EditOpeningTimeCommandHandler implements Command.Handler<EditOpeningTimeCommand, Boolean>{

@Autowired
OpeningTimeRepository openingTimeRepository;


    @Override
    public Boolean handle(EditOpeningTimeCommand command) {
    
        var newEntity = new OpeningTime(command.getId(), command.getBirdParkId(), command.getDayOfWeek(), command.getOpeningTime(), command.getClosingTime());

        var result = openingTimeRepository.save(newEntity);

        if (result != null) {
            return true;
        } else {
            return false;
            
        }
    }
    
}
