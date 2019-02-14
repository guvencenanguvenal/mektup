package com.gcg.mektup.lang.exception;

public class QueueConnectionException extends EventCreateException {

    public QueueConnectionException(String errorMessage){
        super(errorMessage);
    }

    public QueueConnectionException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

}
