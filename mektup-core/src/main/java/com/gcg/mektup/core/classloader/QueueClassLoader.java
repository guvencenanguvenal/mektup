package com.gcg.mektup.core.classloader;

import com.gcg.mektup.core.config.QueueConfiguration;
import com.gcg.mektup.core.log.MektupLog;
import com.gcg.mektup.core.exception.ConfigurationException;
import com.gcg.mektup.queue.adapter.QueueAdapter;

import java.lang.reflect.InvocationTargetException;

public interface QueueClassLoader  {

     static QueueAdapter loadClass() throws ConfigurationException {

        Class queueClass = null;
        Object queueObject = null;

        try {
            queueClass = Class.forName(QueueConfiguration.getInstance().getQueueAdapter());
            queueObject = queueClass.getDeclaredConstructor().newInstance();

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

        if (queueObject instanceof QueueAdapter)
            return (QueueAdapter) queueObject;
        else {
            MektupLog.severe("Queue implementation does not implement QueueAdapter!");
            throw new ConfigurationException("Queue implementation does not implement QueueAdapter!", new ClassCastException());
        }
    }

}
