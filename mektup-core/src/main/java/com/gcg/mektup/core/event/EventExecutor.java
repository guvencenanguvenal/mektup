package com.gcg.mektup.core.event;

import com.gcg.mektup.core.scanner.model.SubscriberInformation;
import com.gcg.mektup.core.subscriber.Caller;
import com.gcg.mektup.core.subscriber.method.InvokeSubscribe;
import com.gcg.mektup.core.event.lang.EventListener;

import java.nio.charset.Charset;

public class EventExecutor {

    public EventExecutor(){}

    public void execute(String routingKey, byte[] output) {
        System.out.println("I am call");
        System.out.println(routingKey);
        System.out.println(new String(output, Charset.forName("UTF-8")));

        EventListener eventListener = SubscriberInformation
                .getInstance()
                .getEventListenerFromQueueName(routingKey);

        Caller caller = new InvokeSubscribe();
        caller.call(eventListener, output);

        //restTemplate.put(url, entity);

        //TODO
        /*RequestMapping requestMapping = eventListener.getSubscriberMethod().getDeclaredAnnotation(RequestMapping.class);
        url += requestMapping.value()[0];*/


    }

}
