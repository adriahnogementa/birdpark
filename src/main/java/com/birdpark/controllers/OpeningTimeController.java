package com.birdpark.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.birdpark.commands.edit.EditOpeningTimeCommand;
import com.birdpark.dto.OpeningTimeDto;
import com.birdpark.entity.OpeningTime;
import com.birdpark.queries.OpeningTimeQuery;

import an.awesome.pipelinr.Pipeline;

@RestController
@RequestMapping("/openingtime")
public class OpeningTimeController extends BaseController {

    @Autowired
    Pipeline pipeline;

    @PostMapping("/edit")
    public ResponseEntity<String> editOpeningTime(@RequestBody List<OpeningTimeDto> dtos) {
        EditOpeningTimeCommand command = new EditOpeningTimeCommand();
        dtos.stream()
                .forEach(dto -> command.add(new OpeningTime(dto.getId(), dto.getBirdParkId(), dto.getDayOfWeek(),
                        dto.getOpeningTime(), dto.getClosingTime())));
        return this.execute(command);
    }

    @GetMapping("/get")
    public List<OpeningTimeDto> getOpeningTime() {
        OpeningTimeQuery query = new OpeningTimeQuery(1);
        return query.execute(pipeline);
    }

}