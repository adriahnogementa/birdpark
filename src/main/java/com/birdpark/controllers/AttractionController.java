package com.birdpark.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.birdpark.commands.EditAttractionCommand;
import com.birdpark.commands.delete.DeleteAttractionCommand;
import com.birdpark.dto.AttractionDto;
import com.birdpark.dto.AttractionForUserDto;
import com.birdpark.entity.Attraction;
import com.birdpark.queries.AttractionForUserQuery;

import an.awesome.pipelinr.Pipeline;

@RestController
@RequestMapping("/attraction")
public class AttractionController extends BaseController {

    @Autowired
    Pipeline pipeline;

    @PostMapping("/edit")
    public ResponseEntity<String> editAttraction(@RequestBody List<AttractionDto> dtos) {
        EditAttractionCommand command = new EditAttractionCommand();
        dtos.stream()
                .forEach(dto -> command
                        .add(new Attraction(dto.getId(), dto.getAttractionName(), dto.getLogo(), dto.getDescription(),
                                dto.getDurationInMinutes(), dto.getTourId())));
        return this.execute(command);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteAttraction(@RequestBody AttractionDto dto) {
        DeleteAttractionCommand command = new DeleteAttractionCommand(dto.getId());
        return this.execute(command);
    }

    @GetMapping("/getUserView")
    public List<AttractionForUserDto> getAttraction() {
        AttractionForUserQuery query = new AttractionForUserQuery();
        return query.execute(pipeline);
    }

}
