package com.gcg.mektup.event;

import com.gcg.mektup.core.event.EventCreator;
import com.gcg.mektup.core.exception.EventCreateException;

public class MektupEvent {

    public static void create(Long eventId, byte[] input) throws EventCreateException {

        EventCreator eventCreator = new EventCreator();
        eventCreator.create(eventId, input);

    }

}
