package com.gcg.mektup.publish;

import com.gcg.mektup.queue.adapter.QueueAdapter;
import com.gcg.mektup.queue.adapter.impl.RabbitmqAdapter;

public class Publisher {

    public void basicPublish(){
        //TODO

        QueueAdapter queueAdapter = new RabbitmqAdapter();
        queueAdapter.basicPublish();

        return;
    }

}
