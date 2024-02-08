package com.birdpark.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

@Entity
@Table(name = "parkinformation")
public class ParkInformation{

    @Column(name = "parkname")
    private String parkName;

    @Column(name = "parklocation")
    private String parkLocation;

    @Column(name = "parkdescription")
    private String parkDescription;

}