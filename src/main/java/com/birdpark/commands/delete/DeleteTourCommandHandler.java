package com.birdpark.commands.delete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.birdpark.entity.Tour;
import com.birdpark.exception.DatabaseException;
import com.birdpark.repository.TourRepository;

import an.awesome.pipelinr.Command;

@Component
public class DeleteTourCommandHandler implements Command.Handler<DeleteTourCommand, Boolean>{


    @Autowired
    TourRepository tourRepository;

    @Override
    public Boolean handle(DeleteTourCommand command) {
       
        var entity = new Tour();
        entity.setTourId(command.getTourId());

        try {
            tourRepository.delete(entity);
            return true;
        } catch (IllegalArgumentException e) {
            throw new DatabaseException("Delete Command on Tour Table couldn't be executed.");
        }
    }
    
}
