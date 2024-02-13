package com.birdpark.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "attractions")
public class Attraction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attraction_id")
    private Integer id;

    @Column(name = "name")
    private String attractionName;

    @Column(name = "logo")
    private byte[] attractionLogo;

    @Column(name = "description")
    private String attractionDescription;

    @Column(name = "duration_in_minutes")
    private Integer durationInMinutes;

    @Column(name = "tour_id")
    private Integer tourId;

    public Attraction() {
    }

    public Attraction(Integer id, String attractionName, byte[] attractionLogo, String attractionDescription,
            Integer durationInMinutes, Integer tourId) {
        this.id = id;
        this.attractionName = attractionName;
        this.attractionLogo = attractionLogo;
        this.attractionDescription = attractionDescription;
        this.durationInMinutes = durationInMinutes;
        this.tourId = tourId;
    }

}
