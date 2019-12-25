package com.gcg.mektup.core.exception;

public class EventCreateException extends EventException {

    public EventCreateException(String errorMessage){
        super(errorMessage);
    }

    public EventCreateException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

}