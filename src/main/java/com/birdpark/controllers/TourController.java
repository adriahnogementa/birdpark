package com.birdpark.controllers;

import java.util.List;

import org.hibernate.sql.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.birdpark.commands.delete.DeleteTourCommand;
import com.birdpark.commands.edit.EditTourCommand;
import com.birdpark.dto.TourDto;
import com.birdpark.queries.TourQuery;

import an.awesome.pipelinr.Pipeline;

@RestController
@RequestMapping("/tour")
public class TourController extends BaseController {

    @Autowired
    Pipeline pipeline;

    @GetMapping("/get")
    public List<TourDto> getTour() {
        TourQuery query = new TourQuery();
        return query.execute(pipeline);

    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/getTourByAttraction")
    public List<TourDto> getTourByAttraction(@RequestBody List<String> attractionDto) {
        TourQuery query = new TourQuery();
        List<TourDto> tourList = query.execute(pipeline);
        return tourList.stream()
        .filter(tour -> attractionDto.stream().allMatch(
            attraction -> tour.getAttractions().stream().anyMatch(
                attractionTour -> attractionTour.getAttractionName().equals(attraction))
        ))
        .toList();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteTour(@RequestBody Integer tourId) {
        DeleteTourCommand command = new DeleteTourCommand(tourId);
        return this.execute(command);
    }

    @PostMapping("/edit")
    public ResponseEntity<String> editTour(@RequestBody EditTourCommand command) {
        return this.execute(command);
    }

}
