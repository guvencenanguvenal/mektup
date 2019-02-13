package com.gcg.mektup.lang.event;

import com.gcg.mektup.lang.queue.QueueInformation;

import java.lang.reflect.Method;

public class EventListener {

    //EventListener Informations
    private Long eventId;

    //Queue Informations
    private QueueInformation queueInformation;

    //Service Information
    private final Class<?> subscriberClass;
    private final Method subscriberMethod;
    private final Class<?>[] subscriberMethodInputs;

    public EventListener(Class<?> subscriberClass, Method subscriberMethod, Class<?>[] subscriberMethodInputs) {
        this.subscriberClass = subscriberClass;
        this.subscriberMethod = subscriberMethod;
        this.subscriberMethodInputs = subscriberMethodInputs;
    }


    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Class<?> getSubscriberClass() {
        return subscriberClass;
    }

    public Method getSubscriberMethod() {
        return subscriberMethod;
    }

    public Class<?>[] getSubscriberMethodInputs() {
        return subscriberMethodInputs;
    }

    public QueueInformation getQueueInformation() {
        return queueInformation;
    }

    public void setQueueInformation(QueueInformation queueInformation) {
        this.queueInformation = queueInformation;
    }
}
