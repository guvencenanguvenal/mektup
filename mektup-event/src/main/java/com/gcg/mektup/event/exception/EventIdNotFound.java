package com.gcg.mektup.event.exception;

import com.gcg.mektup.event.exception.EventCreateException;

public class EventIdNotFound extends EventCreateException {
    public EventIdNotFound(String errorMessage) {
        super(errorMessage);
    }

    public EventIdNotFound(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
