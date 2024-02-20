package com.birdpark.queries;

import com.birdpark.dto.AttractionDto;
import com.birdpark.dto.TagDto;
import com.birdpark.dto.TourDto;
import com.birdpark.entity.Attraction;
import com.birdpark.entity.Tag;
import com.birdpark.entity.Tour;
import com.birdpark.repository.AttractionRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import an.awesome.pipelinr.Command;

@Component
public class AttractionQueryHandler
        implements Command.Handler<AttractionQuery, List<AttractionDto>> {

    @Autowired
    AttractionRepository repository;

    @Override
    public List<AttractionDto> handle(AttractionQuery command) {

        List<Attraction> attractionList = repository.findAll();

        if (!attractionList.isEmpty()) {

            return attractionList.stream().map(attraction -> mapToDto(attraction)).toList();

        } else {
            throw new RuntimeException("Attractions not found");
        }

    }

    private AttractionDto mapToDto(Attraction attraction) {
        return new AttractionDto(attraction.getId(), attraction.getAttractionName(), attraction.getAttractionLogo(),
                attraction.getAttractionDescription(), attraction.getDurationInMinutes(), mapToTagStringList(attraction.getTagList()), mapToTourStringList(attraction.getTourList()));
    }

    private List<String> mapToTourStringList(List<Tour> tourList) {
        return tourList.stream().map(tour -> tour.getTourName()).toList();
    }

    private List<String> mapToTagStringList(List<Tag> tagList) {
        return tagList.stream().map(tag -> tag.getTagName()).toList();
    }

}
