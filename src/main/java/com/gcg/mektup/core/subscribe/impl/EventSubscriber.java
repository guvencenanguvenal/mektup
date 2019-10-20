package com.gcg.mektup.core.subscribe.impl;

import com.gcg.mektup.lang.event.EventListener;
import com.gcg.mektup.core.scanner.model.SubscriberInformation;
import com.gcg.mektup.core.subscribe.method.Caller;
import com.gcg.mektup.core.subscribe.method.InvokeSubscribe;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;

import java.io.IOException;
import java.nio.charset.Charset;

public class EventSubscriber implements Consumer {

    private volatile String _consumerTag;

    @Override
    public void handleConsumeOk(String consumerTag) {
        this._consumerTag = consumerTag;
    }

    @Override
    public void handleCancelOk(String s) {


    }

    @Override
    public void handleCancel(String s) throws IOException {

    }

    @Override
    public void handleShutdownSignal(String s, ShutdownSignalException e) {

    }

    @Override
    public void handleRecoverOk(String s) {

    }

    @Override
    public void handleDelivery(String s, Envelope envelope, AMQP.BasicProperties basicProperties, byte[] bytes) throws IOException {

        System.out.println("I am call");
        System.out.println(envelope.getRoutingKey());
        System.out.println(new String(bytes, Charset.forName("UTF-8")));

        EventListener eventListener = SubscriberInformation
                .getInstance()
                .getEventListenerFromQueueName(envelope.getRoutingKey());

        Caller caller = new InvokeSubscribe();
        caller.call(eventListener, bytes);

        //restTemplate.put(url, entity);

        //TODO
        /*RequestMapping requestMapping = eventListener.getSubscriberMethod().getDeclaredAnnotation(RequestMapping.class);
        url += requestMapping.value()[0];





*/
    }
}
