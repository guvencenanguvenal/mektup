package com.gcg.mektup.subscribe.impl;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;

import java.io.IOException;
import java.nio.charset.Charset;

public class EventConsumer implements Consumer {

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

        System.out.println("I am subscribe");
        System.out.println(envelope.getRoutingKey());
        System.out.println(new String(bytes, Charset.forName("UTF-8")));

    }
}
