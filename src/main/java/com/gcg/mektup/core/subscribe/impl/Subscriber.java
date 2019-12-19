package com.gcg.mektup.core.subscribe.impl;

import com.gcg.mektup.lang.exception.ConfigurationException;
import com.gcg.mektup.lang.exception.EventException;
import com.gcg.mektup.core.queue.QueueFactory;
import com.gcg.mektup.core.queue.adapter.QueueAdapter;
import com.gcg.mektup.core.queue.adapter.impl.RabbitmqAdapter;
import com.gcg.mektup.core.scanner.model.SubscriberInformation;
import com.rabbitmq.client.Consumer;

public class Subscriber {

    public void subscribe(int subscriberId) throws EventException {

        QueueAdapter queueAdapter = null;

        try {
            queueAdapter = QueueFactory.getQueue();
        } catch (ConfigurationException e) {
            throw new EventException("Queue adapter is not valid!", e);
        }
        queueAdapter.connect();

        queueAdapter.consumer(
                SubscriberInformation.getInstance().getEventListenerList().get(subscriberId).getQueueInformation().getQueueName()
        );

    }

}
