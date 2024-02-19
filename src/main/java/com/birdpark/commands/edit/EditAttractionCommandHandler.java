package com.birdpark.commands.edit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.birdpark.repository.AttractionRepository;

import an.awesome.pipelinr.Command;

@Component
public class EditAttractionCommandHandler implements Command.Handler<EditAttractionCommand, Boolean> {

    @Autowired
    AttractionRepository attractionRepository;

    @Override
    public Boolean handle(EditAttractionCommand command) {

        boolean allSaved = command.stream()
                .map(attractionRepository::save)
                .noneMatch(saved -> false);

        if (allSaved) {
            return true;
        } else {
            return false;

        }

    }

}
