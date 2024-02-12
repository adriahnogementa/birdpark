package com.birdpark.queries;

import com.birdpark.dto.ParkInformationDto;
import an.awesome.pipelinr.Command;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ParkInformationQuery implements Command<ParkInformationDto>{

    private Integer id;
}
