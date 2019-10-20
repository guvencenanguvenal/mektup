package com.gcg.mektup.core.subscribe.impl;

import com.gcg.mektup.lang.exception.EventException;
import com.gcg.mektup.core.queue.QueueFactory;
import com.gcg.mektup.core.queue.adapter.QueueAdapter;
import com.gcg.mektup.core.queue.adapter.impl.RabbitmqAdapter;
import com.gcg.mektup.core.scanner.model.SubscriberInformation;
import com.rabbitmq.client.Consumer;

public class Subscriber {

    public void subscribe(int subscriberId) throws EventException {

        QueueAdapter queueAdapter = QueueFactory.getQueue();
        queueAdapter.connect();

        Consumer consumer = new EventSubscriber();

        ((RabbitmqAdapter) queueAdapter).receive(
                SubscriberInformation.getInstance().getEventListenerList().get(subscriberId).getQueueInformation().getQueueName(),
                SubscriberInformation.getInstance().getEventListenerList().get(subscriberId).getSubscriberMethod().getName() + "_tag",
                consumer);

    }

}
