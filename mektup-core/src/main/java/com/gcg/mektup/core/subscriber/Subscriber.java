package com.gcg.mektup.core.subscriber;

import com.gcg.mektup.core.exception.ConfigurationException;
import com.gcg.mektup.core.exception.EventException;
import com.gcg.mektup.core.queue.QueueFactory;
import com.gcg.mektup.core.scanner.model.SubscriberInformation;
import com.gcg.mektup.queue.adapter.QueueAdapter;
import com.gcg.mektup.queue.exception.QueueConfigurationException;
import com.gcg.mektup.queue.exception.QueueConnectionException;

public class Subscriber {

    public void subscribe(int subscriberId) throws QueueConnectionException, QueueConfigurationException {

        QueueAdapter queueAdapter = null;

        try {
            queueAdapter = QueueFactory.getQueue();
        } catch (ConfigurationException e) {
            throw new QueueConfigurationException("Queue adapter is not valid!", e);
        }
        queueAdapter.connect();

        queueAdapter.consumer(
                SubscriberInformation.getInstance().getEventListenerList().get(subscriberId).getQueueInformation().getQueueName()
        );

    }

}
