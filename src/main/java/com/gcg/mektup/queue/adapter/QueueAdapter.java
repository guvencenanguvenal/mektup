package com.gcg.mektup.queue.adapter;

import com.gcg.mektup.lang.exception.QueueConnectionException;

public interface QueueAdapter {

    void connect() throws QueueConnectionException;

    void send(String var1, String var2, byte[] var4) throws QueueConnectionException;

    void close();

}
