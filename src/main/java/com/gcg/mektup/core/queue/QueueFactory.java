package com.gcg.mektup.core.queue;

import com.gcg.mektup.core.queue.adapter.QueueAdapter;
import com.gcg.mektup.core.queue.adapter.impl.RabbitmqAdapter;

public class QueueFactory {

    public static QueueAdapter getQueue(){
        //TODO read from properties which adapter do you use
        return new RabbitmqAdapter();
    }

}
