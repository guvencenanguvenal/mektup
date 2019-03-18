package com.gcg.mektup.queue;

import com.gcg.mektup.queue.adapter.QueueAdapter;
import com.gcg.mektup.queue.adapter.impl.RabbitmqAdapter;

public class QueueFactory {


    public static QueueAdapter getQueue(){
        return new RabbitmqAdapter();
    }

}
