package com.birdpark.queries;

import com.birdpark.dto.AttractionDto;
import java.util.List;
import an.awesome.pipelinr.Command;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AttractionQuery implements Command<List<AttractionDto>> {

}