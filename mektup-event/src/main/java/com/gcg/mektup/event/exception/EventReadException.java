package com.gcg.mektup.event.exception;

import com.gcg.mektup.event.exception.EventException;

public class EventReadException extends EventException {
    public EventReadException(String errorMessage) {
        super(errorMessage);
    }

    public EventReadException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
