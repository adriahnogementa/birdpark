package com.birdpark.commands;

import java.util.ArrayList;

import com.birdpark.entity.Attraction;

import an.awesome.pipelinr.Command;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class EditAttractionCommand extends ArrayList<Attraction> implements Command<Boolean> {

}
