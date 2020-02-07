package com.gcg.mektup.event.exception;

public class EventException extends Exception {

    public EventException(String errorMessage){
        super(errorMessage);
    }

    public EventException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
