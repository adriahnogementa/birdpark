package com.birdpark.commands.edit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.birdpark.entity.Attraction;
import com.birdpark.repository.AttractionRepository;

import an.awesome.pipelinr.Command;

@Component
public class EditAttractionCommandHandler implements Command.Handler<EditAttractionCommand, Boolean> {

    @Autowired
    AttractionRepository attractionRepository;

    @Override
    public Boolean handle(EditAttractionCommand command) {

    var newEntity = new Attraction();

    newEntity.setId(command.getAttractionId());
    newEntity.setAttractionName(command.getAttractionName());
    newEntity.setAttractionDescription(command.getAttractionDescription());
    newEntity.setDurationInMinutes(command.getAttractionDurationInMinutes());
    newEntity.setAttractionLogo(command.getAttractionLogo());

        var result =  attractionRepository.save(newEntity);

        if (result != null) {
            return true;
        }
        return false;
    }

}
