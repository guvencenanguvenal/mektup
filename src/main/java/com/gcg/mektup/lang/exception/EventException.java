package com.gcg.mektup.lang.exception;

public class EventException extends MektupException {

    public EventException(String errorMessage){
        super(errorMessage);
    }

    public EventException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
