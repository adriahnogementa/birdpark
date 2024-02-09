package com.birdpark.repository;

import org.springframework.stereotype.Repository;

import com.birdpark.entity.OpeningTime;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface OpeningTimeRepository extends JpaRepository<OpeningTime, Integer>{
}
