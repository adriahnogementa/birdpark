package com.birdpark.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

@Entity
@Table(name = "attractions")
public class AttractionForUser {

    @Id
    @Column(name = "attraction_id")
    private Integer id;

    @Column(name = "name")
    private String attractionName;

    @Column(name = "logo")
    private byte[] attractionLogo;

    @Column(name = "description")
    private String attractionDescription;

    @Column(name = "tags")
    private String tags;

    @Column(name = "tour")
    private String tour;

    public AttractionForUser() {
    }

}