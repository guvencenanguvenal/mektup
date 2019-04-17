package com.gcg.mektup.publish;

import com.gcg.mektup.lang.event.EventListener;
import com.gcg.mektup.lang.exception.EventCreateException;
import com.gcg.mektup.queue.QueueFactory;
import com.gcg.mektup.queue.adapter.QueueAdapter;
import com.gcg.mektup.scanner.model.SubscriberInformation;

public class EventCreator {

    public void create(Long eventId, byte[] input) throws EventCreateException {

        QueueAdapter queueAdapter = QueueFactory.getQueue();

        queueAdapter.connect();
        EventListener eventListener = SubscriberInformation.getInstance().getEventListenerFromEventId(eventId);
        queueAdapter.send(
                eventListener.getQueueInformation().getExchangeName(),
                eventListener.getQueueInformation().getQueueName(),
                input);

        queueAdapter.close();

    }

}
