package com.birdpark.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.birdpark.dto.AttractionForUserDto;
import com.birdpark.queries.AttractionForUserQuery;

import an.awesome.pipelinr.Pipeline;

@RestController
@RequestMapping("/attraction")
public class AttractionController extends BaseController {

    @Autowired
    Pipeline pipeline;

    @GetMapping("/getUserView")
    public List<AttractionForUserDto> getAttraction() {
        AttractionForUserQuery query = new AttractionForUserQuery();
        return query.execute(pipeline);
    }

}
