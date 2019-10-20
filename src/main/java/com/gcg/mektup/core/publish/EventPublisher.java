package com.gcg.mektup.core.publish;

import com.gcg.mektup.core.log.MektupLog;
import com.gcg.mektup.lang.event.EventListener;
import com.gcg.mektup.lang.exception.EventCreateException;
import com.gcg.mektup.core.queue.QueueFactory;
import com.gcg.mektup.core.queue.adapter.QueueAdapter;
import com.gcg.mektup.core.scanner.model.SubscriberInformation;

public class EventPublisher {

    public void publish(Long eventId, byte[] input) throws EventCreateException {

        QueueAdapter queueAdapter = QueueFactory.getQueue();

        queueAdapter.connect();
        EventListener eventListener = SubscriberInformation.getInstance().getEventListenerFromEventId(eventId);
        queueAdapter.send(
                eventListener.getQueueInformation().getExchangeName(),
                eventListener.getQueueInformation().getQueueName(),
                input);

        MektupLog.info("Event sending queue.");

        queueAdapter.close();

    }

}
