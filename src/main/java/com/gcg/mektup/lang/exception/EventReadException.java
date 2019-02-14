package com.gcg.mektup.lang.exception;

public class EventReadException extends EventException {
    public EventReadException(String errorMessage) {
        super(errorMessage);
    }

    public EventReadException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
