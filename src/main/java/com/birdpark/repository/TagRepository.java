package com.birdpark.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.birdpark.entity.Tag;

public interface TagRepository extends JpaRepository<Tag, Integer> {

}
