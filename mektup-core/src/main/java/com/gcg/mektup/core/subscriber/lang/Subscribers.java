package com.gcg.mektup.core.subscriber.lang;

import com.gcg.mektup.scanner.lang.SubscriberInformation;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Subscribers {

    private final List<com.gcg.mektup.scanner.lang.SubscriberInformation> subscriberInformationList;
    private final HashMap<Long, com.gcg.mektup.scanner.lang.SubscriberInformation> hashEventListenerFromEventId = new HashMap<>();

    private Subscribers(List<com.gcg.mektup.scanner.lang.SubscriberInformation> subscriberInformationList) {
        this.subscriberInformationList = Collections.unmodifiableList(subscriberInformationList);
        for (SubscriberInformation subscriberInformation : subscriberInformationList){
            hashEventListenerFromEventId.put(subscriberInformation.getEventId(), subscriberInformation);
        }
    }

    private static Subscribers INSTANCE = null;

    public static Subscribers createInstance(List<SubscriberInformation> subscriberInformationList) {
        if (null != Subscribers.INSTANCE)
            return Subscribers.INSTANCE;

        return Subscribers.INSTANCE = new Subscribers(subscriberInformationList);
    }

    public static Subscribers getInstance(){
        return Subscribers.INSTANCE;
    }

    public List<SubscriberInformation> getEventListenerList() {
        if (null != Subscribers.INSTANCE) {
            return Subscribers.INSTANCE.subscriberInformationList;
        }

        throw new NullPointerException(); //because it always has a list or empty list
    }

    public SubscriberInformation getEventListenerFromQueueName(String queueName) {
        for (int i = 0; i < this.subscriberInformationList.size(); i++) {
            if (this.subscriberInformationList
                    .get(i)
                    .getChannelInformation().getQueueName().equals(queueName))
                return this.subscriberInformationList
                        .get(i);
        }

        return null;
    }
}
