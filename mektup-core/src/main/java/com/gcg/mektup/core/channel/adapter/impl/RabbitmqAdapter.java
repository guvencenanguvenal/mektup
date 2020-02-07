package com.gcg.mektup.core.channel.adapter.impl;

import com.gcg.mektup.event.lang.EventInformation;
import com.gcg.mektup.channel.ChannelAdapter;
import com.gcg.mektup.channel.exception.ChannelConfigurationException;
import com.gcg.mektup.channel.exception.ChannelConnectionException;
import com.gcg.mektup.scanner.lang.SubscriberInformation;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitmqAdapter implements ChannelAdapter {

    private ConnectionFactory factory = new ConnectionFactory();
    private Connection conn;
    private Channel channel;

    public void connect() throws ChannelConnectionException {

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
            throw new ChannelConnectionException(e.getMessage(), e);
        } catch (TimeoutException e) {
            throw new ChannelConnectionException(e.getMessage(), e);
        }


    }

    public void send(EventInformation eventInformation, byte[] var) throws ChannelConnectionException {
        try {

            if (null == conn){
                throw new ChannelConnectionException("Queue is not Connect");
            }

            channel.basicPublish(eventInformation.getExchangeName(), eventInformation.getQueueName(), null, var);

            channel.close();

        } catch (IOException e) {
            throw new ChannelConnectionException(e.getMessage(), e);
        } catch (TimeoutException e) {
            throw new ChannelConnectionException(e.getMessage(), e);
        }

    }

    @Override
    public void consumer(SubscriberInformation subscriberInformation) throws ChannelConfigurationException {

        Consumer consumer = new RabbitmqEventConsumer();

        this.receive(
                subscriberInformation.getChannelInformation().getQueueName(),
                subscriberInformation.getChannelInformation().getQueueName() + "_tag",
                consumer);

    }

    public void receive(String queueName, String tag, Consumer consumer) throws ChannelConfigurationException {
        try {

            channel.basicConsume(queueName, true, tag, consumer);
        } catch (IOException e) {
        throw  new ChannelConfigurationException(e.getMessage(), e);
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
