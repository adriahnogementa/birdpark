package com.birdpark.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

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