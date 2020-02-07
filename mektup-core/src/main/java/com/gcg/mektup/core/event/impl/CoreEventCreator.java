package com.gcg.mektup.core.event.impl;

import com.gcg.mektup.core.exception.ConfigurationException;
import com.gcg.mektup.core.log.MektupLog;
import com.gcg.mektup.core.queue.QueueFactory;
import com.gcg.mektup.event.EventCreator;
import com.gcg.mektup.event.exception.EventCreateException;
import com.gcg.mektup.event.lang.EventInformation;
import com.gcg.mektup.queue.adapter.QueueAdapter;
import com.gcg.mektup.queue.exception.QueueConfigurationException;
import com.gcg.mektup.queue.exception.QueueConnectionException;

public class CoreEventCreator implements EventCreator {

    public CoreEventCreator(){ }

    public void create(EventInformation eventInformation, byte[] input) throws EventCreateException {

        try {
            QueueAdapter queueAdapter = null;

            try {
                queueAdapter = QueueFactory.getQueue();
            } catch (ConfigurationException e) {
                e.printStackTrace();
            }

            queueAdapter.connect();
            queueAdapter.send(
                    eventInformation,
                    input);

            MektupLog.info("Id : " + eventInformation.getEventId() + " event sending queue.");

            //queueAdapter.close();
        } catch (QueueConnectionException e) {
            throw new EventCreateException(e.getMessage(), e);
        } catch (QueueConfigurationException e) {
            throw new EventCreateException(e.getMessage(), e);
        }
    }

}
