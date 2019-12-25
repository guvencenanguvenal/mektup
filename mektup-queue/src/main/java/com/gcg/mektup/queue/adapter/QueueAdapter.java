package com.gcg.mektup.queue.adapter;

import com.gcg.mektup.queue.exception.QueueConfigurationException;
import com.gcg.mektup.queue.exception.QueueConnectionException;

public interface QueueAdapter {

    void connect() throws QueueConnectionException, QueueConfigurationException;

    void send(String var1, String var2, byte[] var4) throws QueueConnectionException, QueueConfigurationException;

    void consumer(String var1) throws QueueConfigurationException;

    void close();

}
