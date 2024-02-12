package com.birdpark.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.birdpark.entity.ParkInformation;
import com.birdpark.repository.ParkinformationRepository;

import an.awesome.pipelinr.Command;

@Component
public class EditParkInformationCommandHandler implements Command.Handler<EditParkInformationCommand, Boolean> {

    @Autowired
    ParkinformationRepository parkinformationRepository;

    @Override
    public Boolean handle(EditParkInformationCommand command) {

        var newEntity = new ParkInformation(1, command.getParkName(), command.getParkLocation(),
                command.getParkDescription(), command.getParkLogo());

        var result = parkinformationRepository.save(newEntity);

        if (result != null) {
            return true;
        }
        return false;

    }
}
