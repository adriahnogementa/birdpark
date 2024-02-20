package com.birdpark.commands.delete;

import an.awesome.pipelinr.Command;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DeleteTourCommand implements Command<Boolean>{

    private Integer tourId;
    
}
