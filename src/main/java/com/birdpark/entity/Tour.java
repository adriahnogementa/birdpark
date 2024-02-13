package com.birdpark.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "tour")
public class Tour {

    @Id
    @Column(name = "tour_id")
    private Integer tourId;

    @Column(name = "name")
    private String tourName;
    
    public Tour() {
    }

    public Tour(Integer tourId, String tourName) {
        this.tourId = tourId;
        this.tourName = tourName;
    }
}
