package com.birdpark.entity;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "tour")
public class Tour {

    @Id
    @Column(name = "tour_id")
    private Integer tourId;

    @Column(name = "logo")
    private byte[] logo;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "duration_in_minutes")
    private Integer durationInMinutes;

    @Column(name = "name")
    private String tourName;

    @Column(name = "begin_time")
    private LocalTime beginTime;

    @Column(name = "end_time")
    private LocalTime endTime;

    @OneToMany(mappedBy = "tour")
    private List<AttractionTour> attractionTourList;

    public Tour() {
    }

}
