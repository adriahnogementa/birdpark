package com.birdpark.commands.edit;

import java.math.BigDecimal;
import java.time.LocalTime;
import an.awesome.pipelinr.Command;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class EditTourCommand implements Command<Boolean>{

    private int tourId;
    private byte[] logo;
    private BigDecimal price;
    private String tourName;
    private LocalTime beginTime;

    public EditTourCommand(int tourId, byte[] logo, BigDecimal price, String tourName, LocalTime beginTime) {
        this.tourId = tourId;
        this.logo = logo;
        this.price = price;
        this.tourName = tourName;
        this.beginTime = beginTime;
    
    }
    
}
