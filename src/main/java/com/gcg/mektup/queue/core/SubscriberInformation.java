package com.gcg.mektup.queue.core;

import com.gcg.mektup.lang.event.EventListener;
import com.gcg.mektup.subscribe.impl.Subscriber;

import java.util.Collections;
import java.util.List;

public class SubscriberInformation {

    private final List<EventListener> eventListenerListenerList;


    private SubscriberInformation(List<EventListener> eventListenerList) {

        this.eventListenerListenerList = Collections.unmodifiableList(eventListenerList);
    }

    private static SubscriberInformation INSTANCE = null;

    public static void createInstance(List<EventListener> eventListenerList) {
        if (null != SubscriberInformation.INSTANCE)
            return;

        SubscriberInformation.INSTANCE = new SubscriberInformation(eventListenerList);
    }

    public static List<EventListener> getEventListenerList() {
        if (null != SubscriberInformation.INSTANCE) {
            return SubscriberInformation.INSTANCE.eventListenerListenerList;
        }

        throw new NullPointerException();
    }

    public static EventListener getEventListenerFromQueueName(String queuName) {
        for (int i = 0; i < SubscriberInformation.INSTANCE.eventListenerListenerList.size(); i++) {
            if (SubscriberInformation
                    .INSTANCE
                    .eventListenerListenerList
                    .get(i)
                    .getQueueInformation().getQueueName().equals(queuName))
                return SubscriberInformation
                        .INSTANCE
                        .eventListenerListenerList
                        .get(i);
        }
        return null;
    }
}
