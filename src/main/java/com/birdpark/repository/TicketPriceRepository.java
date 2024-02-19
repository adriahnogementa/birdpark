package com.birdpark.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.birdpark.entity.TicketPrice;

@Repository
public interface TicketPriceRepository extends JpaRepository<TicketPrice, Integer> {

    List<TicketPrice> findByBirdParkId(Integer birdParkId);

}
