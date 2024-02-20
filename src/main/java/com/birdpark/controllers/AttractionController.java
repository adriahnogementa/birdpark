package com.birdpark.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.birdpark.commands.delete.DeleteAttractionCommand;
import com.birdpark.commands.edit.EditAttractionCommand;
import com.birdpark.dto.AttractionDto;
import com.birdpark.dto.TagDto;
import com.birdpark.entity.Attraction;
import com.birdpark.queries.AttractionQuery;

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
                        .add(createNewAttraction(dto)));
        return this.execute(command);
    }

    private Attraction createNewAttraction(AttractionDto dto) {
        Attraction attraction = new Attraction();
        attraction.setId(dto.getAttraction_id());
        attraction.setAttractionName(dto.getAttractionName());
        attraction.setAttractionLogo(dto.getLogo());
        attraction.setAttractionDescription(dto.getDescription());
        attraction.setDurationInMinutes(dto.getDurationInMinutes());
        return attraction;
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteAttraction(@RequestBody AttractionDto dto) {
        DeleteAttractionCommand command = new DeleteAttractionCommand(dto.getAttraction_id());
        return this.execute(command);
    }

    @GetMapping("/getUserView")
    public List<AttractionDto> getAttractionUserView() {
        AttractionQuery query = new AttractionQuery();
        return query.execute(pipeline);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/getUserViewByTag")
    public List<AttractionDto> getAttractionUserViewByTag(@RequestBody List<TagDto> tagDto) {
        AttractionQuery query = new AttractionQuery();
        List<AttractionDto> attractionList = query.execute(pipeline);
        return attractionList.stream()
                .filter(attraction -> tagDto.stream().allMatch(
                        tag -> attraction.getTags().stream()
                                .anyMatch(attractionTag -> attractionTag.equals(tag.getTagName()))))
                .toList();
    }

}
