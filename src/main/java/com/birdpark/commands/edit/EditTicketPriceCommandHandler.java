package com.birdpark.commands.edit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.birdpark.repository.TicketPriceRepository;

import an.awesome.pipelinr.Command;

@Component
public class EditTicketPriceCommandHandler implements Command.Handler<EditTicketPriceCommand, Boolean> {

    @Autowired
    TicketPriceRepository ticketPriceRepository;

    @Override
    public Boolean handle(EditTicketPriceCommand commands) {
        boolean allSaved = commands.stream()
                .map(ticketPriceRepository::save)
                .noneMatch(saved -> false);

        if (allSaved) {
            return true;
        } else {
            return false;

        }
    }

}
