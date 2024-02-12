package com.birdpark.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.birdpark.commands.EditParkInformationCommand;
import com.birdpark.dto.ParkInformationDto;
import com.birdpark.queries.ParkInformationQuery;

import an.awesome.pipelinr.Pipeline;

@RestController
@RequestMapping("/parkinformation")
public class ParkInformationController extends BaseController {

    @Autowired
    Pipeline pipeline;

    @PostMapping("/edit")
    public ResponseEntity<String> editParkInformation(@RequestBody ParkInformationDto dto) {

        EditParkInformationCommand command = new EditParkInformationCommand(dto.getParkName(),
        dto.getParkLocation(), dto.getParkDescription(), dto.getParkLogo());
        return this.execute(command);
    }

    @GetMapping("/get")
    public ParkInformationDto getParkInformation() {
        ParkInformationQuery query = new ParkInformationQuery(1);
        return query.execute(pipeline);
    }

}