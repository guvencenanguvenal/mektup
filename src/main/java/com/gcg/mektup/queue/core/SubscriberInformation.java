package com.gcg.mektup.queue.core;

import com.gcg.mektup.lang.event.EventListener;

import java.util.Collections;
import java.util.List;

public class SubscriberInformation {

    private final List<EventListener> eventListenerListenerList;


    private SubscriberInformation(List<EventListener> eventListenerList){

        this.eventListenerListenerList = Collections.unmodifiableList(eventListenerList);
    }

    private static SubscriberInformation INSTANCE = null;

    public static void createInstance(List<EventListener> eventListenerList){
        if (null != SubscriberInformation.INSTANCE)
            return;

        SubscriberInformation.INSTANCE = new SubscriberInformation(eventListenerList);
    }

    public static List<EventListener> getEventListenerList(){
        if (null != SubscriberInformation.INSTANCE){
            return SubscriberInformation.INSTANCE.eventListenerListenerList;
        }

        throw new NullPointerException();
    }

}
