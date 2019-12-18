package com.gcg.mektup.core.queue.adapter;

import com.gcg.mektup.lang.exception.EventException;
import com.gcg.mektup.lang.exception.QueueConnectionException;

public interface QueueAdapter {

    void connect() throws QueueConnectionException;

    void send(String var1, String var2, byte[] var4) throws QueueConnectionException;

    void consumer(String var1) throws EventException;

    void close();

}
