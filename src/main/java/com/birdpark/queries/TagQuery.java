package com.birdpark.queries;

import an.awesome.pipelinr.Command;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.List;

import com.birdpark.dto.TagDto;

@Getter
@AllArgsConstructor
public class TagQuery implements Command<List<TagDto>>{
    
}
