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
@Table(name = "parkinformation")
public class ParkInformation{

    @Id
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "parkname")
    private String parkName;

    @Column(name = "parklocation")
    private String parkLocation;

    @Column(name = "parkdescription")
    private String parkDescription;

    @Column(name = "parklogo")
    private byte[] parkLogo;

    public ParkInformation() {
    }

    public ParkInformation(String parkName, String parkLocation, String parkDescription, byte[] parkLogo) {
        this.parkName = parkName;
        this.parkLocation = parkLocation;
        this.parkDescription = parkDescription;
        this.parkLogo = parkLogo;
    }

    public ParkInformation(String parkName, String parkLocation, String parkDescription) {
        this.parkName = parkName;
        this.parkLocation = parkLocation;
        this.parkDescription = parkDescription;
    }
}