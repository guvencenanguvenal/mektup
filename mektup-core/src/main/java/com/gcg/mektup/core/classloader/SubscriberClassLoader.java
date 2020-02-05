package com.gcg.mektup.core.classloader;

import com.gcg.mektup.core.config.MektupConfiguration;
import com.gcg.mektup.core.exception.ConfigurationException;
import com.gcg.mektup.core.log.MektupLog;
import com.gcg.mektup.scanner.adapter.SubscriberScanner;

import java.lang.reflect.InvocationTargetException;

public class SubscriberClassLoader {

    public static SubscriberScanner loadClass() throws ConfigurationException {

        Class subscriberClass = null;
        Object subscriber = null;

        try {
            subscriberClass = Class.forName(MektupConfiguration.getInstance().getListenerScanner());
            subscriber = subscriberClass.getDeclaredConstructor().newInstance();

            MektupLog.info("QueueAdapter created!");

        } catch (ClassNotFoundException e) {
            MektupLog.severe("SubscriberScanner is not valid!");
            throw new ConfigurationException("SubscriberScanner is not valid!", e);
        } catch (InstantiationException e) {
            MektupLog.severe("SubscriberScanner is not valid!");
            throw new ConfigurationException("SubscriberScanner is not valid!", e);
        } catch (IllegalAccessException e) {
            MektupLog.severe("SubscriberScanner is not valid!");
            throw new ConfigurationException("SubscriberScanner is not valid!", e);
        } catch (InvocationTargetException e) {
            MektupLog.severe("SubscriberScanner is not valid!");
            throw new ConfigurationException("SubscriberScanner is not valid!", e);
        } catch (NoSuchMethodException e) {
            MektupLog.severe("SubscriberScanner is not valid!");
            throw new ConfigurationException("SubscriberScanner is not valid!", e);
        }

        if (subscriber instanceof SubscriberScanner)
            return (SubscriberScanner) subscriber;
        else {
            MektupLog.severe("SubscriberScanner implementation does not implement SubscriberScanner!");
            throw new ConfigurationException("SubscriberScanner implementation does not implement SubscriberScanner!", new ClassCastException());
        }
    }
}
