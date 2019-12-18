package com.gcg.mektup.core.classloader;

import com.gcg.mektup.core.queue.adapter.QueueAdapter;

public class QueueClassLoader  {

    public static QueueAdapter loadClass() throws Exception {

        Class exampleClass = Class.forName("com.gcg.mektup.core.queue.adapter.impl.RabbitmqAdapter");
        Object ob = exampleClass.getDeclaredConstructor().newInstance();

        if (ob instanceof QueueAdapter)
            return (QueueAdapter) ob;
        else
            throw new Exception("object is not queueadapter");

    }

}
