package com.gcg.mektup.core.subscribe.thread;

import com.gcg.mektup.lang.exception.EventException;
import com.gcg.mektup.core.subscribe.impl.Subscriber;

public class SubscriberThread implements Runnable {

    private int subscriberId;

    public SubscriberThread(int subscriberId){
        this.subscriberId = subscriberId;
    }

    @Override
    public void run() {
        try {
            new Subscriber().subscribe(this.subscriberId);
        } catch (EventException e) {
            e.printStackTrace();
        }

    }

}