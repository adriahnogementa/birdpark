package com.birdpark.commands;

import an.awesome.pipelinr.Command;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DeleteAttractionCommand implements Command<Boolean> {

    private Integer id;
}
