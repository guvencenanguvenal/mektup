package com.gcg.mektup.queue.exception;

public class QueueException extends Exception {

    public QueueException(String errorMessage){
        super(errorMessage);
    }

    public QueueException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

}
