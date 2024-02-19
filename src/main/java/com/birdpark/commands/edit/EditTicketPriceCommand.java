package com.birdpark.commands.edit;

import java.util.ArrayList;

import com.birdpark.entity.TicketPrice;

import an.awesome.pipelinr.Command;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class EditTicketPriceCommand extends ArrayList<TicketPrice> implements Command<Boolean> {

}
