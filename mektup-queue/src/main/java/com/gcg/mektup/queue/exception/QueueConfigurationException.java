package com.gcg.mektup.queue.exception;

public class QueueConfigurationException extends QueueException {

    public QueueConfigurationException(String errorMessage){
        super(errorMessage);
    }

    public QueueConfigurationException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

}
