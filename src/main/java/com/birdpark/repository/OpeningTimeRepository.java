package com.birdpark.repository;

import org.springframework.stereotype.Repository;

import com.birdpark.entity.OpeningTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;


@Repository
public interface OpeningTimeRepository extends JpaRepository<OpeningTime, Integer>{

    @Query(value = "SELECT * FROM openingtime WHERE bird_park_id = ?1", nativeQuery = true)
    List<OpeningTime> findByBirdId(Integer id);
}
