package com.gcg.mektup.queue.exception;


public class QueueConnectionException extends QueueException {

    public QueueConnectionException(String errorMessage){
        super(errorMessage);
    }

    public QueueConnectionException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

}
