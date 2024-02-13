package com.birdpark.queries;

import java.util.List;

import com.birdpark.dto.OpeningTimeDto;
import an.awesome.pipelinr.Command;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OpeningTimeQuery implements Command<List<OpeningTimeDto>> {

    private Integer bird_park_id;

}
