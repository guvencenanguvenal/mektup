package com.gcg.mektup.queue.adapter;

import com.gcg.mektup.event.lang.EventInformation;
import com.gcg.mektup.queue.exception.QueueConfigurationException;
import com.gcg.mektup.queue.exception.QueueConnectionException;
import com.gcg.mektup.scanner.lang.SubscriberInformation;

public interface QueueAdapter {

    void connect() throws QueueConnectionException, QueueConfigurationException;

    void send(EventInformation eventInformation, byte[] input) throws QueueConnectionException, QueueConfigurationException;

    void consumer(SubscriberInformation subscriberInformation) throws QueueConfigurationException;

    void close();

}
