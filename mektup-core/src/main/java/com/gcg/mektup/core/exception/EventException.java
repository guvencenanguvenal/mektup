package com.gcg.mektup.core.exception;

public class EventException extends MektupException {

    public EventException(String errorMessage){
        super(errorMessage);
    }

    public EventException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
