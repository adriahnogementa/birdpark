package com.birdpark.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.birdpark.dto.AttractionDto;
import com.birdpark.queries.AttractionQuery;

import an.awesome.pipelinr.Pipeline;

@RestController
@RequestMapping("/attraction")
public class AttractionController extends BaseController {

    @Autowired
    Pipeline pipeline;

    @GetMapping("/get")
    public List<AttractionDto> getAttraction() {
        AttractionQuery query = new AttractionQuery();
        return query.execute(pipeline);
    }

}
