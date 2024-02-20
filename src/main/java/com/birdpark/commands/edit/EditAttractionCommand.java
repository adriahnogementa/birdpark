package com.birdpark.commands.edit;

import an.awesome.pipelinr.Command;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class EditAttractionCommand implements Command<Boolean> {

    private int attractionId;
    private String attractionName;
    private byte[] attractionLogo;
    private String attractionDescription;
    private Integer attractionDurationInMinutes;
   

    public EditAttractionCommand(int attractionId, String attractionName, 
    byte[] attractionLogo, String attractionDescription, Integer attractionDurationInMinutes) {
        this.attractionId = attractionId;
        this.attractionName = attractionName;
        this.attractionDescription = attractionDescription;
        this.attractionDurationInMinutes = attractionDurationInMinutes;
    }

}
