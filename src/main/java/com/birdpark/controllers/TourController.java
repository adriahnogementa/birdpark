package com.birdpark.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import an.awesome.pipelinr.Pipeline;

@RestController
@RequestMapping("/tour")
public class TourController extends BaseController {

    @Autowired
    Pipeline pipeline;

}
