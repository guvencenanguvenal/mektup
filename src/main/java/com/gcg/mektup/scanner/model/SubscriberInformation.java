package com.gcg.mektup.scanner.model;

import com.gcg.mektup.lang.event.EventListener;
import com.gcg.mektup.lang.exception.EventIdNotFound;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class SubscriberInformation {

    private final List<EventListener> eventListenerListenerList;
    private final HashMap<Long, EventListener> hashEventListenerFromEventId = new HashMap<>();


    private SubscriberInformation(List<EventListener> eventListenerList) {
        this.eventListenerListenerList = Collections.unmodifiableList(eventListenerList);
        for (EventListener eventListener : eventListenerList){
            hashEventListenerFromEventId.put(eventListener.getEventId(), eventListener);
        }
    }

    private static SubscriberInformation INSTANCE = null;

    public static void createInstance(List<EventListener> eventListenerList) {
        if (null != SubscriberInformation.INSTANCE)
            return;

        SubscriberInformation.INSTANCE = new SubscriberInformation(eventListenerList);
    }

    public static SubscriberInformation getInstance(){
        return SubscriberInformation.INSTANCE;
    }

    public List<EventListener> getEventListenerList() {
        if (null != SubscriberInformation.INSTANCE) {
            return SubscriberInformation.INSTANCE.eventListenerListenerList;
        }

        throw new NullPointerException();
    }

    public EventListener getEventListenerFromEventId(Long eventId) throws EventIdNotFound{
        EventListener eventListener = this.hashEventListenerFromEventId.get(eventId);

        if (null == eventListener)
            throw new EventIdNotFound("EventId " + eventId + " not found!");

        return eventListener;
    }

    public EventListener getEventListenerFromQueueName(String queuName) {
        for (int i = 0; i < this.eventListenerListenerList.size(); i++) {
            if (this.eventListenerListenerList
                    .get(i)
                    .getQueueInformation().getQueueName().equals(queuName))
                return this.eventListenerListenerList
                        .get(i);
        }
        return null;
    }
}
