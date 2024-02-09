package com.birdpark.queries;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.birdpark.dto.ParkInformationDto;
import com.birdpark.entity.ParkInformation;
import com.birdpark.exception.DatabaseException;
import com.birdpark.repository.ParkinformationRepository;

import an.awesome.pipelinr.Command;

public class ParkInformationQuery implements Command<ParkInformationDto>{

    @Autowired
    ParkinformationRepository repository;

    public ParkInformationDto execute(){
        List<ParkInformation> parkInformationList = repository.findAll();
       
        return parkInformationList.stream().findFirst().map(parkInformation -> mapToDto(parkInformation)).orElseThrow(() -> new DatabaseException("Park Information not found"));
    }


    private ParkInformationDto mapToDto(ParkInformation parkInformation){

        return new ParkInformationDto(parkInformation.getParkName(), parkInformation.getParkLocation(), parkInformation.getParkDescription(), parkInformation.getParkLogo());
    }
}
