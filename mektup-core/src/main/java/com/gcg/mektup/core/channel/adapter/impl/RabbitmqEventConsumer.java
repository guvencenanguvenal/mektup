package com.gcg.mektup.core.channel.adapter.impl;

import com.gcg.mektup.core.event.EventExecutor;
import com.gcg.mektup.core.subscriber.lang.Subscribers;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;

import java.io.IOException;

public class RabbitmqEventConsumer implements Consumer {

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

        EventExecutor eventExecutor = new EventExecutor();
        eventExecutor.execute(Subscribers.getInstance().getEventListenerFromQueueName(envelope.getRoutingKey()), bytes);

    }
}
