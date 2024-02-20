package com.birdpark.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.birdpark.entity.Tour;

@Repository
public interface TourRepository extends JpaRepository<Tour, Integer>{

    
    
}
