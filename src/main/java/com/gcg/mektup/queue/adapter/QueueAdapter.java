package com.gcg.mektup.queue.adapter;

import com.gcg.mektup.lang.exception.EventException;

public interface QueueAdapter {

    void connect() throws EventException;

    void basicPublish(String var1, String var2, byte[] var4) throws EventException;

    void close();

}
