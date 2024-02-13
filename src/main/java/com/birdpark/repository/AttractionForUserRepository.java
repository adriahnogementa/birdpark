package com.birdpark.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.birdpark.entity.AttractionForUser;

import java.util.List;

public interface AttractionForUserRepository extends JpaRepository<AttractionForUser, Integer>{

    
    @Query(value = "SELECT\r\n" + //
                "    a.attraction_id,"+
                "    a.name AS name,\r\n" + //
                "    encode(a.logo, 'hex') AS logo,\r\n" + //
                "    a.description AS description,\r\n" + //
                "    string_agg(t.name, ',') AS tags,\r\n" + //
                "    tour.name AS tour\r\n" + //
                "FROM\r\n" + //
                "    attractions a\r\n" + //
                "LEFT JOIN\r\n" + //
                "    attractionTags at ON a.attraction_id = at.attraction_id\r\n" + //
                "LEFT JOIN\r\n" + //
                "    tags t ON at.tag_id = t.tag_id\r\n" + //
                "LEFT JOIN\r\n" + //
                "    tour ON a.tour_id = tour.tour_id\r\n" + //
                "GROUP BY\r\n" + //
                "     a.attraction_id, a.name, a.logo, a.description, tour.name;", nativeQuery = true)
    List<AttractionForUser> findAllAttractionWithTagsAndTours();
    
}
