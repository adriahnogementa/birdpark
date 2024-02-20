package com.birdpark.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
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

    @OneToMany(mappedBy = "attraction")
    private List<AttractionTour> attractionTourList;

    @ManyToMany
    @JoinTable(name = "attractiontours",
    joinColumns = @JoinColumn(name = "attraction_id"),
    inverseJoinColumns = @JoinColumn(name = "tour_id"))
    @Column(name = "tour")
    private List<Tour> tourList;

    @ManyToMany
    @JoinTable(name = "attractiontags",
    joinColumns = @JoinColumn(name = "attraction_id"),
    inverseJoinColumns = @JoinColumn(name = "tag_id"))
    @Column(name = "tag")
    private List<Tag> tagList;

    public Attraction() {
    }

}
