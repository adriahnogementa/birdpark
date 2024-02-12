package com.birdpark.queries;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.birdpark.dto.ParkInformationDto;
import com.birdpark.entity.ParkInformation;
import com.birdpark.repository.ParkinformationRepository;

import an.awesome.pipelinr.Command;

@Component
public class ParkInformationQueryHandler implements Command.Handler<ParkInformationQuery, ParkInformationDto>{

@Autowired
ParkinformationRepository repository;

    @Override
    public ParkInformationDto handle(ParkInformationQuery command) {
        
        Optional <ParkInformation> parkInformationOptional = repository.findById(command.getId());
    

        if (parkInformationOptional.isPresent()) {
            ParkInformation parkInformation =  parkInformationOptional.get();
            return new ParkInformationDto(parkInformation.getParkName(), parkInformation.getParkLocation(), parkInformation.getParkDescription(), parkInformation.getParkLogo());
        } else {
            throw new RuntimeException("Park Information not found");            
        }
    
    }
    

}
