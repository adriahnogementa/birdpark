package com.birdpark.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.birdpark.commands.EditAttractionCommand;
import com.birdpark.commands.delete.DeleteAttractionCommand;
import com.birdpark.dto.AttractionDto;
import com.birdpark.dto.AttractionForUserDto;
import com.birdpark.dto.TagDto;
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

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/getUserViewByTag")
    public List<AttractionForUserDto> getAttractionByTag(@RequestBody List<TagDto> tagDto) {
        AttractionForUserQuery query = new AttractionForUserQuery();
        List<AttractionForUserDto> attractionList = query.execute(pipeline);
        return attractionList.stream()
                .filter(attraction -> tagDto.stream().allMatch(
                        tag -> attraction.getTags().stream()
                                .anyMatch(attractionTag -> attractionTag.equals(tag.getTagName()))))
                .toList();
    }

}
