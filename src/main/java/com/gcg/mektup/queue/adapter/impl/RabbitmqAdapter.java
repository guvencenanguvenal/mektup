package com.gcg.mektup.queue.adapter.impl;

import com.gcg.mektup.lang.exception.EventException;
import com.gcg.mektup.lang.exception.EventReadException;
import com.gcg.mektup.lang.exception.QueueConnectionException;
import com.gcg.mektup.queue.adapter.QueueAdapter;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitmqAdapter implements QueueAdapter {

    private ConnectionFactory factory = new ConnectionFactory();
    private Connection conn;
    private Channel channel;

    public void connect() throws EventException {

        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setVirtualHost("/");
        factory.setHost("localhost");
        factory.setPort(5672);


        try {
            conn = factory.newConnection();
            channel = conn.createChannel();
        } catch (IOException e) {
            throw new QueueConnectionException(e.getMessage(), e);
        } catch (TimeoutException e) {
            throw new QueueConnectionException(e.getMessage(), e);
        }


    }

    public void basicPublish(String exchangeName, String queueName, byte[] var) throws EventException {
        try {

            if (null == conn){
                throw new QueueConnectionException("Queue is not Connect");
            }

            channel.basicPublish("TEST.EXCH", "TEST.QUEUE", null, "DENEME".getBytes());

            channel.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

    }

    public void basicConsume(String queueName, String tag, Consumer consumer) throws EventException {
        try {
            channel.basicConsume(queueName, true, tag, consumer);
        } catch (IOException e) {
            throw  new EventReadException(e.getMessage(), e);
        }
    }

    public void close(){

        try {
            conn.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
