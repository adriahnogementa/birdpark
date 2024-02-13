package com.birdpark.queries;

import com.birdpark.dto.AttractionForUserDto;

import java.util.List;
import an.awesome.pipelinr.Command;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AttractionForUserQuery implements Command<List<AttractionForUserDto>> {

}