package com.birdpark.queries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.birdpark.dto.TagDto;
import com.birdpark.entity.Tag;
import com.birdpark.repository.TagRepository;

import java.util.List;
import an.awesome.pipelinr.Command;

@Component
public class TagQueryHandler implements Command.Handler<TagQuery, List<TagDto>>{

    @Autowired
    TagRepository repository;

    @Override
    public List<TagDto> handle(TagQuery command) {
        List<Tag> tagList = repository.findAll();
        if (!tagList.isEmpty()) {
            return tagList.stream().map(tag -> mapToDto(tag)).toList();
        }else {
            throw new RuntimeException("Tags not found");
        }
    }

    private TagDto mapToDto(Tag tag) {
        return new TagDto(tag.getTagId(), tag.getTagName());
    }
    
}
