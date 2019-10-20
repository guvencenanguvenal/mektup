package com.gcg.mektup.event;

import com.gcg.mektup.core.publish.EventPublisher;
import com.gcg.mektup.lang.exception.EventCreateException;

public class EventCreator {

    private EventCreator(){ }

    public static void create(Long eventId, byte[] input) throws EventCreateException {
        EventPublisher creator = new EventPublisher();
        creator.publish(eventId, input);
    }

}
