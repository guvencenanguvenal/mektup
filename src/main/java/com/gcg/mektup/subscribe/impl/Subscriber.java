package com.gcg.mektup.subscribe.impl;

import com.gcg.mektup.lang.exception.EventException;
import com.gcg.mektup.queue.QueueFactory;
import com.gcg.mektup.queue.adapter.QueueAdapter;
import com.gcg.mektup.queue.adapter.impl.RabbitmqAdapter;
import com.gcg.mektup.queue.core.SubscriberInformation;
import com.rabbitmq.client.Consumer;

public class Subscriber {

    public void subscribe(int subscriberId) throws EventException {

        QueueAdapter queueAdapter = QueueFactory.getQueue();
        queueAdapter.connect();


        Consumer consumer = new EventConsumer();

        ((RabbitmqAdapter) queueAdapter).basicConsume(
                SubscriberInformation.getEventListenerList().get(subscriberId).getQueueInformation().getQueueName(),
                SubscriberInformation.getEventListenerList().get(subscriberId).getSubscriberMethod().getName() + "_tag",
                consumer);

    }

}
