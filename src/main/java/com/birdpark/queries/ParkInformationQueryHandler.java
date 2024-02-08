package com.birdpark.queries;

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
        
        ParkInformation parkInformation = repository.findById(1L).get();
    
        if (parkInformation != null) {
            return new ParkInformationDto();
            //TODO: Search for the park information and return it
        } else {
            return null;
            
        }
    
    }
    

}
