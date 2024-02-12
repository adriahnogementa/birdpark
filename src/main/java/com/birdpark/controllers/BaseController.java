package com.birdpark.controllers;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.birdpark.exception.CommandValidationException;
import com.birdpark.utilities.StackTraceUtilities;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Pipeline;

@RestController
public abstract class BaseController {

  @Autowired
  Pipeline pipeline;

  @Autowired
  Logger logger;

  public ResponseEntity<String> execute(Command<Boolean> command) {

    String commandName = command.getClass().getSimpleName();
    logger.info("----- Create {} from HTTP request", commandName);

    try {
      Boolean success = command.execute(pipeline);
      if (success) {
        return new ResponseEntity<String>(String.format("%s successfully executed", commandName), HttpStatus.OK);
      } else {
        return new ResponseEntity<String>(String.format("%s unsuccessfully executed", commandName),
            HttpStatus.INTERNAL_SERVER_ERROR);
      }
    } catch (CommandValidationException exception) {
      StackTraceUtilities.printShortStackTrace(exception, 2);
      return new ResponseEntity<String>(String.format("Validation of %s failed", commandName), HttpStatus.BAD_REQUEST);
    } catch (Exception exception) {
      StackTraceUtilities.printShortStackTrace(exception, 2);
      return new ResponseEntity<String>(String.format("%s produced unexpected errors", commandName),
          HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}