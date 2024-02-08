package com.birdpark.repository;

import org.springframework.stereotype.Repository;
import com.birdpark.entity.ParkInformation;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface ParkinformationRepository extends JpaRepository<ParkInformation, Long>{
}
