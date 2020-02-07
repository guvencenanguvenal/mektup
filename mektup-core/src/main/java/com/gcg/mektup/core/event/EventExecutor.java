package com.gcg.mektup.core.event;

import com.gcg.mektup.core.classloader.EventServiceCallerClassLoader;
import com.gcg.mektup.core.exception.ConfigurationException;
import com.gcg.mektup.core.subscriber.lang.Subscribers;
import com.gcg.mektup.event.caller.Caller;
import com.gcg.mektup.scanner.lang.SubscriberInformation;

import java.nio.charset.Charset;

public class EventExecutor {

    public EventExecutor(){}

    public void execute(String routingKey, byte[] output) {
        System.out.println("I am call");
        System.out.println(routingKey);
        System.out.println(new String(output, Charset.forName("UTF-8")));

        SubscriberInformation subscriberInformation = Subscribers
                .getInstance()
                .getEventListenerFromQueueName(routingKey);

        Caller caller = null;

        try {
            caller = EventServiceCallerClassLoader.loadClass();
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }

        caller.call(subscriberInformation, output);

        //restTemplate.put(url, entity);

        //TODO
        /*RequestMapping requestMapping = eventListener.getSubscriberMethod().getDeclaredAnnotation(RequestMapping.class);
        url += requestMapping.value()[0];*/


    }

}
