package com.gcg.mektup.core.event;

import com.gcg.mektup.core.classloader.EventServiceCallerClassLoader;
import com.gcg.mektup.core.exception.ConfigurationException;
import com.gcg.mektup.core.subscriber.lang.Subscribers;
import com.gcg.mektup.event.caller.Caller;
import com.gcg.mektup.scanner.lang.SubscriberInformation;

import java.nio.charset.Charset;

public class EventExecutor implements com.gcg.mektup.event.EventExecutor {

    public EventExecutor(){}

    @Override
    public void execute(SubscriberInformation subscriberInformation, byte[] output) {

        System.out.println("I am call");
        System.out.println(subscriberInformation.getChannelInformation().getQueueName());
        System.out.println(new String(output, Charset.forName("UTF-8")));

        Caller caller = null;

        try {
            caller = EventServiceCallerClassLoader.loadClass();
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }

        caller.call(subscriberInformation, output);

    }
}
