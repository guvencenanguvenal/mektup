package com.gcg.mektup.channel.exception;

public class ChannelConfigurationException extends ChannelException {

    public ChannelConfigurationException(String errorMessage){
        super(errorMessage);
    }

    public ChannelConfigurationException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

}
