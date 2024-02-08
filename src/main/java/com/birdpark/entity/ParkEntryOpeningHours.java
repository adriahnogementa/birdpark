package com.birdpark.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter 
@Getter
@NoArgsConstructor
public class ParkEntryOpeningHours {
        
        private String openingTime;
        private String closingTime;
        private String dayOfWeek;
        
}
