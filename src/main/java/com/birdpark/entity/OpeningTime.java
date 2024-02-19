package com.birdpark.entity;

import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

@Entity
@Table(name = "openingtime")
public class OpeningTime {

        @Id
        @Column(name = "id")
        private Integer id;

        @Column(name = "bird_park_id")
        private Integer birdParkId;

        @Column(name = "day_of_week")
        private String dayOfWeek;

        @Column(name = "opening_time")
        private LocalTime openingTime;

        @Column(name = "closing_time")
        private LocalTime closingTime;

        public OpeningTime() {
        }

        public OpeningTime(Integer id, Integer birdParkId, String dayOfWeek, LocalTime openingTime,
                        LocalTime closingTime) {
                this.id = id;
                this.birdParkId = birdParkId;
                this.dayOfWeek = dayOfWeek;
                this.openingTime = openingTime;
                this.closingTime = closingTime;
        }
}
