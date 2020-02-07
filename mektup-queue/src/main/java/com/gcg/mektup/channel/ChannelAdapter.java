package com.gcg.mektup.channel;

import com.gcg.mektup.event.lang.EventInformation;
import com.gcg.mektup.channel.exception.ChannelConfigurationException;
import com.gcg.mektup.channel.exception.ChannelConnectionException;
import com.gcg.mektup.scanner.lang.SubscriberInformation;

public interface ChannelAdapter {

    void connect() throws ChannelConnectionException, ChannelConfigurationException;

    void send(EventInformation eventInformation, byte[] input) throws ChannelConnectionException, ChannelConfigurationException;

    void consumer(SubscriberInformation subscriberInformation) throws ChannelConfigurationException;

    void close();

}
