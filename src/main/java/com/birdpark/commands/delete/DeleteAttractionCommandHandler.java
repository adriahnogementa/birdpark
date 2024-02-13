package com.birdpark.commands.delete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;

import com.birdpark.entity.Attraction;
import com.birdpark.repository.AttractionRepository;

import an.awesome.pipelinr.Command;

public class DeleteAttractionCommandHandler implements Command.Handler<DeleteAttractionCommand, Boolean> {

    @Autowired
    AttractionRepository attractionRepository;

    @Override
    public Boolean handle(DeleteAttractionCommand command) {

        var entity = new Attraction();
        entity.setId(command.getId());
        try {
            attractionRepository.delete(entity);
            return true;
        } catch (OptimisticLockingFailureException e) {
            return false;
        }
    }

}