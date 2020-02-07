package com.gcg.mektup.core.queue.adapter.impl;

import com.gcg.mektup.event.lang.EventInformation;
import com.gcg.mektup.queue.adapter.QueueAdapter;
import com.gcg.mektup.queue.exception.QueueConfigurationException;
import com.gcg.mektup.queue.exception.QueueConnectionException;
import com.gcg.mektup.scanner.lang.SubscriberInformation;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitmqAdapter implements QueueAdapter {

    private ConnectionFactory factory = new ConnectionFactory();
    private Connection conn;
    private Channel channel;

    public void connect() throws QueueConnectionException {

        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setVirtualHost("/");
        factory.setHost("localhost");
        factory.setPort(5672);

        factory.setRequestedHeartbeat(60);

        try {
            conn = factory.newConnection();
            channel = conn.createChannel();
        } catch (IOException e) {
            throw new QueueConnectionException(e.getMessage(), e);
        } catch (TimeoutException e) {
            throw new QueueConnectionException(e.getMessage(), e);
        }


    }

    public void send(EventInformation eventInformation, byte[] var) throws QueueConnectionException {
        try {

            if (null == conn){
                throw new QueueConnectionException("Queue is not Connect");
            }

            channel.basicPublish(eventInformation.getExchangeName(), eventInformation.getQueueName(), null, var);

            channel.close();

        } catch (IOException e) {
            throw new QueueConnectionException(e.getMessage(), e);
        } catch (TimeoutException e) {
            throw new QueueConnectionException(e.getMessage(), e);
        }

    }

    @Override
    public void consumer(SubscriberInformation subscriberInformation) throws QueueConfigurationException {

        Consumer consumer = new EventExecuter();

        this.receive(
                subscriberInformation.getChannelInformation().getQueueName(),
                subscriberInformation.getChannelInformation().getQueueName() + "_tag",
                consumer);

    }

    public void receive(String queueName, String tag, Consumer consumer) throws QueueConfigurationException {
        try {

            channel.basicConsume(queueName, true, tag, consumer);
        } catch (IOException e) {
        throw  new QueueConfigurationException(e.getMessage(), e);
        }
    }

    @Override
    public void close(){

        try {
            conn.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
