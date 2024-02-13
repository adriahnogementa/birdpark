package com.birdpark.queries;

import com.birdpark.dto.AttractionForUserDto;
import com.birdpark.entity.AttractionForUser;
import com.birdpark.repository.AttractionForUserRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import an.awesome.pipelinr.Command;

@Component
public class AttractionForUserQueryHandler implements Command.Handler<AttractionForUserQuery, List<AttractionForUserDto>>{

    @Autowired
    AttractionForUserRepository repository;

    @Override
    public List<AttractionForUserDto> handle(AttractionForUserQuery command) {
    
        List<AttractionForUser> attractionForUserList = repository.findAllAttractionWithTagsAndTours();

        if (!attractionForUserList.isEmpty()) {
            
            return attractionForUserList.stream().map(attractionForUser -> mapToDto(attractionForUser)).toList();
            
        }else {
            throw new RuntimeException("Attractions not found");
        }
        
    }

    private AttractionForUserDto mapToDto(AttractionForUser attractionForUser) {
        return new AttractionForUserDto(attractionForUser.getId(),attractionForUser.getAttractionName(), attractionForUser.getAttractionDescription(), attractionForUser.getAttractionLogo(), generateListOfTags(attractionForUser), attractionForUser.getTour());
    }

    private List<String> generateListOfTags(AttractionForUser attractionForUser) {
      
        return List.of(attractionForUser.getTags().split(","));
    }
    
}
