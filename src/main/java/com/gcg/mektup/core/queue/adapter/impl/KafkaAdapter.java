package com.gcg.mektup.core.queue.adapter.impl;

import com.gcg.mektup.lang.exception.EventException;
import com.gcg.mektup.lang.exception.QueueConnectionException;
import com.gcg.mektup.core.queue.adapter.QueueAdapter;

public class KafkaAdapter implements QueueAdapter {
    @Override
    public void connect() throws QueueConnectionException {

    }

    @Override
    public void send(String var1, String var2, byte[] var4) throws QueueConnectionException {

    }

    @Override
    public void consumer(String var1) throws EventException {

    }

    @Override
    public void close() {

    }
}
