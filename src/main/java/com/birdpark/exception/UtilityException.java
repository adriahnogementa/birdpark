package com.birdpark.exception;

public class UtilityException extends RuntimeException{
    public UtilityException(String message, Throwable cause) {
        super(message, cause);
    }

    public UtilityException(String message) {
        super(message);
    }
}
