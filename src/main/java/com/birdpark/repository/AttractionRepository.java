package com.birdpark.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.birdpark.entity.Attraction;

@Repository
public interface AttractionRepository extends JpaRepository<Attraction, Integer> {

}
