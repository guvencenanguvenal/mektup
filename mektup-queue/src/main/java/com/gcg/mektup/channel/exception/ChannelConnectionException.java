package com.gcg.mektup.channel.exception;


public class ChannelConnectionException extends ChannelException {

    public ChannelConnectionException(String errorMessage){
        super(errorMessage);
    }

    public ChannelConnectionException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

}
