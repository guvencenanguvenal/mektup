package com.gcg.mektup.publish;

import com.gcg.mektup.lang.exception.EventCreateException;
import com.gcg.mektup.lang.exception.EventException;
import com.gcg.mektup.lang.exception.QueueConnectionException;
import com.gcg.mektup.queue.adapter.QueueAdapter;
import com.gcg.mektup.queue.adapter.impl.RabbitmqAdapter;

public class EventCreator {

    public void create() throws EventException {

        QueueAdapter queueAdapter = new RabbitmqAdapter();

        try {
            queueAdapter.connect();
        } catch (Exception e) {
            throw new EventCreateException(e.getMessage(), e);
        }

        try {
            queueAdapter.basicPublish("", "", null);
        } catch (Exception e) {
           throw new QueueConnectionException(e.getMessage(), e);
        }

        queueAdapter.close();

    }

}
