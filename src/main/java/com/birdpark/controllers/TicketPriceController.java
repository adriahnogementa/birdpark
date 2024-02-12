package com.birdpark.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.birdpark.commands.EditTicketPriceCommand;
import com.birdpark.dto.TicketPriceDto;
import com.birdpark.entity.TicketPrice;
import com.birdpark.queries.TicketPriceQuery;

import an.awesome.pipelinr.Pipeline;

import java.util.List;

@RestController
@RequestMapping("/ticketprice")
public class TicketPriceController extends BaseController{


    @Autowired
    Pipeline pipeline;

    @PostMapping("/edit")
    public ResponseEntity<String> editTicketPrice(@RequestBody List<TicketPriceDto> dtos) {
        EditTicketPriceCommand command = new EditTicketPriceCommand();
        dtos.stream()
            .forEach(dto -> command.add(new TicketPrice(dto.getId(), 1, dto.getTicketType(), dto.getPrice())));
        return this.execute(command);
    }

    @GetMapping("/get")
    public List<TicketPriceDto> getTicketPrice() {
        TicketPriceQuery query = new TicketPriceQuery(1);
        return query.execute(pipeline);
    }

    
}
