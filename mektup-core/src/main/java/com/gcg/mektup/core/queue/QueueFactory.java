package com.gcg.mektup.core.queue;

import com.gcg.mektup.core.classloader.QueueClassLoader;
import com.gcg.mektup.core.exception.ConfigurationException;
import com.gcg.mektup.queue.adapter.QueueAdapter;

public class QueueFactory {

    private static QueueAdapter QUEUE_INSTANCE = null;

    public static QueueAdapter getQueue() throws ConfigurationException {

        if (null == QueueFactory.QUEUE_INSTANCE)
            return QueueFactory.QUEUE_INSTANCE = QueueClassLoader.loadClass();
        else
            return QueueFactory.QUEUE_INSTANCE;

    }

}
