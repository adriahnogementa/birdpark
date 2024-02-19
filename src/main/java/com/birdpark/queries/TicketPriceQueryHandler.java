package com.birdpark.queries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.birdpark.dto.TicketPriceDto;
import com.birdpark.entity.TicketPrice;
import com.birdpark.repository.TicketPriceRepository;

import an.awesome.pipelinr.Command;
import java.util.List;

@Component
public class TicketPriceQueryHandler implements Command.Handler<TicketPriceQuery, List<TicketPriceDto>> {

    @Autowired
    TicketPriceRepository repository;

    @Override
    public List<TicketPriceDto> handle(TicketPriceQuery command) {

        if (command.getBirdParkId() == null) {
            throw new IllegalArgumentException("Bird Park ID cannot be null");
        }

        List<TicketPrice> ticketPriceList = repository.findByBirdParkId(command.getBirdParkId());

        if (!ticketPriceList.isEmpty()) {
            return ticketPriceList.stream().map(openingTime -> mapToDto(openingTime)).toList();
        } else {
            throw new RuntimeException("Ticket Price not found");
        }
    }

    private TicketPriceDto mapToDto(TicketPrice ticketPrice) {
        return new TicketPriceDto(ticketPrice.getId(), ticketPrice.getBirdParkId(), ticketPrice.getTicketType(),
                ticketPrice.getPrice());
    }

}
