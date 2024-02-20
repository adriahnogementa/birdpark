package com.birdpark.commands.edit;

import lombok.Getter;

@Getter
public class EditAttractionOrderCommand {
    
    private int attractionId;
    private int order;
    
    public EditAttractionOrderCommand(int attractionId, int order) {
        this.attractionId = attractionId;
        this.order = order;
    }
}
