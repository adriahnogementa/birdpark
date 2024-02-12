package com.birdpark.commands;


import an.awesome.pipelinr.Command;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

import com.birdpark.entity.OpeningTime;


@Getter
@NoArgsConstructor
public class EditOpeningTimeCommand extends ArrayList<OpeningTime> implements Command<Boolean> {
    

}
