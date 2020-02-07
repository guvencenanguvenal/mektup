package com.gcg.mektup.core.subscriber;

import com.gcg.mektup.core.exception.ConfigurationException;
import com.gcg.mektup.core.channel.ChannelFactory;
import com.gcg.mektup.core.subscriber.lang.Subscribers;
import com.gcg.mektup.channel.ChannelAdapter;
import com.gcg.mektup.channel.exception.ChannelConfigurationException;
import com.gcg.mektup.channel.exception.ChannelConnectionException;

public class Subscriber {

    public void subscribe(int subscriberId) throws ChannelConnectionException, ChannelConfigurationException {

        ChannelAdapter channelAdapter = null;

        try {
            channelAdapter = ChannelFactory.getChannel();
        } catch (ConfigurationException e) {
            throw new ChannelConfigurationException("Channel adapter is not valid!", e);
        }
        channelAdapter.connect();

        channelAdapter.consumer(Subscribers.getInstance().getEventListenerList().get(subscriberId));

    }

}
