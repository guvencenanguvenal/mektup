package com.gcg.mektup.core.exception;

public class EventIdNotFound extends EventCreateException {
    public EventIdNotFound(String errorMessage) {
        super(errorMessage);
    }

    public EventIdNotFound(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
