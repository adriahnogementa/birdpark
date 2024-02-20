package com.birdpark.queries;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.birdpark.dto.AttractionDto;
import com.birdpark.dto.TourDto;
import com.birdpark.entity.AttractionTour;
import com.birdpark.entity.Tour;
import com.birdpark.repository.TourRepository;

import an.awesome.pipelinr.Command;

@Component
public class TourQueryHandler implements Command.Handler<TourQuery, List<TourDto>>{

    @Autowired
    TourRepository repository;

    @Override
    public List<TourDto> handle(TourQuery command) {
        List<Tour> tourList = repository.findAll();
        if (!tourList.isEmpty()) {
            return convertToDto(tourList);
        } else {
            throw new RuntimeException("Tours not found");
        }
    }

    private List<TourDto> convertToDto(List<Tour> tourList) {
        List<TourDto> tourDtoList = new ArrayList<>();
        tourList.forEach(tour -> {
            tourDtoList.add(new TourDto(tour.getTourId(), tour.getLogo(), tour.getPrice(), tour.getDurationInMinutes(), tour.getTourName(), tour.getBeginTime(), tour.getEndTime(), mapToAttractionDto(tour.getAttractionTourList())));
        });
        return tourDtoList;
    }

    private List<AttractionDto> mapToAttractionDto(List<AttractionTour> attractionTourList) {
        List<AttractionDto> attractionDtoList = new ArrayList<>();
        attractionTourList.forEach(attractionTour -> {
            attractionDtoList.add(new AttractionDto(attractionTour.getAttraction().getId(), attractionTour.getAttraction().getAttractionName(), attractionTour.getTourOrder()));
        });
        return attractionDtoList;
    }
    
}
