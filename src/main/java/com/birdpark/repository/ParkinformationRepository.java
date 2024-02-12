package com.birdpark.repository;

import org.springframework.stereotype.Repository;
import com.birdpark.entity.ParkInformation;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


@Repository
public interface ParkinformationRepository extends JpaRepository<ParkInformation, Integer>{

    @Query(value = "SELECT * FROM parkinformation WHERE id = ?1 LIMIT 1", nativeQuery = true)
    Optional<ParkInformation> findById(Integer id);
}
