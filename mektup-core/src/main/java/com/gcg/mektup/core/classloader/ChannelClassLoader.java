package com.gcg.mektup.core.classloader;

import com.gcg.mektup.core.config.ChannelConfiguration;
import com.gcg.mektup.core.log.MektupLog;
import com.gcg.mektup.core.exception.ConfigurationException;
import com.gcg.mektup.channel.ChannelAdapter;

import java.lang.reflect.InvocationTargetException;

public interface ChannelClassLoader {

     static ChannelAdapter loadClass() throws ConfigurationException {

        Class queueClass = null;
        Object queueObject = null;

        try {
            queueClass = Class.forName(ChannelConfiguration.getInstance().getQueueAdapter());
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

        if (queueObject instanceof ChannelAdapter)
            return (ChannelAdapter) queueObject;
        else {
            MektupLog.severe("Queue implementation does not implement QueueAdapter!");
            throw new ConfigurationException("Queue implementation does not implement QueueAdapter!", new ClassCastException());
        }
    }

}
