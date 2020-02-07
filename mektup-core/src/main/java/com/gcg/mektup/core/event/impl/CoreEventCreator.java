package com.gcg.mektup.core.event.impl;

import com.gcg.mektup.core.exception.ConfigurationException;
import com.gcg.mektup.core.log.MektupLog;
import com.gcg.mektup.core.channel.ChannelFactory;
import com.gcg.mektup.event.EventCreator;
import com.gcg.mektup.event.exception.EventCreateException;
import com.gcg.mektup.event.lang.EventInformation;
import com.gcg.mektup.channel.ChannelAdapter;
import com.gcg.mektup.channel.exception.ChannelConfigurationException;
import com.gcg.mektup.channel.exception.ChannelConnectionException;

public class CoreEventCreator implements EventCreator {

    public CoreEventCreator(){ }

    public void create(EventInformation eventInformation, byte[] input) throws EventCreateException {

        try {
            ChannelAdapter channelAdapter = null;

            try {
                channelAdapter = ChannelFactory.getChannel();
            } catch (ConfigurationException e) {
                e.printStackTrace();
            }

            channelAdapter.connect();
            channelAdapter.send(
                    eventInformation,
                    input);

            MektupLog.info("Id : " + eventInformation.getEventId() + " event sending queue.");

            //queueAdapter.close();
        } catch (ChannelConnectionException e) {
            throw new EventCreateException(e.getMessage(), e);
        } catch (ChannelConfigurationException e) {
            throw new EventCreateException(e.getMessage(), e);
        }
    }

}
