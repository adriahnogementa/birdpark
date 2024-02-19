package com.birdpark.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.birdpark.dto.TagDto;
import com.birdpark.queries.TagQuery;

import java.util.List;

import an.awesome.pipelinr.Pipeline;

@RestController
@RequestMapping("/tag")
public class TagController extends BaseController {

    @Autowired
    Pipeline pipeline;

    @GetMapping("/get")
    public List<TagDto> getTags() {
        TagQuery query = new TagQuery();
        return query.execute(pipeline);
    }
}
