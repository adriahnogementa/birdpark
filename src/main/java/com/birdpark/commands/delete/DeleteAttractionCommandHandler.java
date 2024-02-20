package com.birdpark.commands.delete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.birdpark.entity.Attraction;
import com.birdpark.exception.DatabaseException;
import com.birdpark.repository.AttractionRepository;

import an.awesome.pipelinr.Command;

@Component
public class DeleteAttractionCommandHandler implements Command.Handler<DeleteAttractionCommand, Boolean> {

    @Autowired
    AttractionRepository attractionRepository;

    @Override
    public Boolean handle(DeleteAttractionCommand command) {

        var entity = new Attraction();
        entity.setId(command.getAttractionId());
        try {
            attractionRepository.delete(entity);
            return true;
        } catch (IllegalArgumentException e) {
            throw new DatabaseException("Delete Command on Attraction Table couldn't be executed.");
        }
    }

}