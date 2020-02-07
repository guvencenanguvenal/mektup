package com.gcg.mektup.channel.exception;

public class ChannelException extends Exception {

    public ChannelException(String errorMessage){
        super(errorMessage);
    }

    public ChannelException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

}
