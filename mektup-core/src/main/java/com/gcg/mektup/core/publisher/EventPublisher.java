package com.gcg.mektup.core.publisher;

import com.gcg.mektup.core.exception.EventIdNotFound;
import com.gcg.mektup.core.log.MektupLog;
import com.gcg.mektup.scanner.lang.EventListener;
import com.gcg.mektup.core.queue.QueueFactory;
import com.gcg.mektup.core.scanner.model.SubscriberInformation;
import com.gcg.mektup.queue.adapter.QueueAdapter;
import com.gcg.mektup.queue.exception.QueueConfigurationException;
import com.gcg.mektup.queue.exception.QueueConnectionException;

public class EventPublisher {

    public void publish(Long eventId, byte[] input) throws EventIdNotFound, QueueConnectionException, QueueConfigurationException {

        QueueAdapter queueAdapter = null;

        try {
            queueAdapter = QueueFactory.getQueue();
        } catch (Exception e) {
            e.printStackTrace();
        }

        queueAdapter.connect();
        EventListener eventListener = SubscriberInformation.getInstance().getEventListenerFromEventId(eventId);
        queueAdapter.send(
                eventListener.getQueueInformation().getExchangeName(),
                eventListener.getQueueInformation().getQueueName(),
                input);

        MektupLog.info("Id : " + eventId + " event sending queue.");

        //queueAdapter.close();

    }

}
