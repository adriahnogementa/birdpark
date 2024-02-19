package com.birdpark.queries;

import an.awesome.pipelinr.Command;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

import com.birdpark.dto.TicketPriceDto;

@Getter
@AllArgsConstructor
public class TicketPriceQuery implements Command<List<TicketPriceDto>> {

    private Integer birdParkId;
}
