package com.gcg.mektup.core.classloader;

import com.gcg.mektup.core.config.QueueConfiguration;
import com.gcg.mektup.core.log.MektupLog;
import com.gcg.mektup.core.queue.adapter.QueueAdapter;
import com.gcg.mektup.lang.exception.ConfigurationException;

import java.lang.reflect.InvocationTargetException;

public class QueueClassLoader  {

    public static QueueAdapter loadClass() throws ConfigurationException {

        Class exampleClass = null;
        Object ob = null;

        try {
            exampleClass = Class.forName(QueueConfiguration.getInstance().getQueueAdapter());
            ob = exampleClass.getDeclaredConstructor().newInstance();

            MektupLog.info("QueueAdapter created!");

        } catch (ClassNotFoundException e) {
            MektupLog.severe("QueueAdapter is not valid!");
            throw new ConfigurationException("QueueAdapter is not valid!", e);
        } catch (InstantiationException e) {
            MektupLog.severe("QueueAdapter is not valid!");
            throw new ConfigurationException("QueueAdapter is not valid!", e);
        } catch (IllegalAccessException e) {
            MektupLog.severe("QueueAdapter is not valid!");
            throw new ConfigurationException("QueueAdapter is not valid!", e);
        } catch (InvocationTargetException e) {
            MektupLog.severe("QueueAdapter is not valid!");
            throw new ConfigurationException("QueueAdapter is not valid!", e);
        } catch (NoSuchMethodException e) {
            MektupLog.severe("QueueAdapter is not valid!");
            throw new ConfigurationException("QueueAdapter is not valid!", e);
        }

        if (ob instanceof QueueAdapter)
            return (QueueAdapter) ob;
        else {
            MektupLog.severe("Queue implementation does not implement QueueAdapter!");
            throw new ConfigurationException("Queue implementation does not implement QueueAdapter!", new ClassCastException());
        }
    }

}
