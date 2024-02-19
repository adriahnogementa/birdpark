package com.birdpark.commands.edit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.birdpark.repository.OpeningTimeRepository;

import an.awesome.pipelinr.Command;

@Component
public class EditOpeningTimeCommandHandler implements Command.Handler<EditOpeningTimeCommand, Boolean> {

    @Autowired
    OpeningTimeRepository openingTimeRepository;

    @Override
    public Boolean handle(EditOpeningTimeCommand commands) {

        boolean allSaved = commands.stream()
                .map(openingTimeRepository::save)
                .noneMatch(saved -> false);

        if (allSaved) {
            return true;
        } else {
            return false;

        }
    }

}
