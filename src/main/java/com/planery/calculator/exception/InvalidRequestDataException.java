package com.planery.calculator.exception;

public class InvalidRequestDataException extends RuntimeException {

    public InvalidRequestDataException(String message) {
        super(message);
    }
}
