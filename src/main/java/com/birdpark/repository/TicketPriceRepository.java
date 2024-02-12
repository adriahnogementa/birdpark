package com.birdpark.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.birdpark.entity.TicketPrice;

import java.util.List;


@Repository
public interface TicketPriceRepository extends JpaRepository<TicketPrice, Integer>{

    @Query(value = "SELECT * FROM ticketprice WHERE bird_park_id = ?1", nativeQuery = true)
    List<TicketPrice> findByBirdId(Integer id);


}
