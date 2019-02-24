package com.gcg.mektup.subscribe.impl;

import com.gcg.mektup.lang.event.EventListener;
import com.gcg.mektup.queue.core.SubscriberInformation;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.charset.Charset;

public class EventConsumer implements Consumer {

    private volatile String _consumerTag;
    private final RestTemplate restTemplate = new RestTemplate();

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

        String url = "http://localhost:8080";

        EventListener eventListener = SubscriberInformation.getEventListenerFromQueueName(envelope.getRoutingKey());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(new String(bytes, Charset.forName("UTF-8")), headers);

        restTemplate.exchange(url + eventListener.getPath(),
                eventListener.getHttpMethod(),
                entity,
                String.class);

        //restTemplate.put(url, entity);

        //TODO
        /*RequestMapping requestMapping = eventListener.getSubscriberMethod().getDeclaredAnnotation(RequestMapping.class);
        url += requestMapping.value()[0];




        Object obj = Mektup.getApplicationContext().getBean(eventListener.getSubscriberClass());

        if (eventListener.getSubscriberMethodInputs().length == 0){
            //eventListener.getSubscriberMethod().invoke(obj);

            restTemplate.getForEntity(url, eventListener.getSubscriberMethod().getReturnType());
        }
        else{
            //TODO : this is not String this must be object
            //TODO : inputtypes annotation control

            //objectMapper.readValue(bytes, eventListener.getSubscriberMethodInputs()[0]);

            System.out.println(url + "?" + eventListener.getSubscriberMethod().getParameters()[0].getName() + "=123");
            restTemplate.getForEntity(url + "?" + eventListener.getSubscriberMethod().getParameters()[0].getName() + "=123", eventListener.getSubscriberMethod().getReturnType());

            //eventListener.getSubscriberMethod().invoke(obj, new String(bytes, Charset.forName("UTF-8")));
        }

*/
    }
}
