package com.birdpark.commands.edit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.birdpark.entity.Tour;
import com.birdpark.repository.TourRepository;

import an.awesome.pipelinr.Command;

@Component
public class EditTourCommandHandler implements Command.Handler<EditTourCommand, Boolean> {

    @Autowired
    TourRepository tourRepository;

    @Override
    public Boolean handle(EditTourCommand command) {
        
        var newEntity = new Tour();
        newEntity.setTourId(command.getTourId());
        newEntity.setTourName(command.getTourName());
        newEntity.setPrice(command.getPrice());
        newEntity.setBeginTime(command.getBeginTime());
        newEntity.setLogo(command.getLogo());        
        var result = tourRepository.save(newEntity);
        
        if (result != null) {
            return true;
        }
        return false;
    }

    
}
