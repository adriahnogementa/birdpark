package com.birdpark.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

@Entity
@Table(name = "tags")
public class Tag {

    @Id
    @Column(name = "tag_id")
    private Integer tagId;

    @Column(name = "name")
    private String tagName;
    
    public Tag() {
    }

    public Tag(Integer tagId, String tagName) {
        this.tagId = tagId;
        this.tagName = tagName;
    }
    
}
