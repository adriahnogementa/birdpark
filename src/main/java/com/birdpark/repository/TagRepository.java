package com.birdpark.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.birdpark.entity.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, Integer> {

}
