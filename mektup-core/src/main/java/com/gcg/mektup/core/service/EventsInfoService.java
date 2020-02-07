package com.gcg.mektup.core.service;

import com.gcg.mektup.core.subscriber.lang.Subscribers;

public class EventsInfoService {

    public EventsInfoService(){}

    public String eventsInfo(){

        StringBuilder response = new StringBuilder();

        response.append("{ \"Event Info\" : [");

        for (int i = 0; i < Subscribers.getInstance().getEventListenerList().size(); i++){
            response.append("{");
            response.append("\"Id\":" + Subscribers.getInstance().getEventListenerList().get(i).getEventId() + ",");
            response.append("\"RequestMethod\":" + "\"" + Subscribers.getInstance().getEventListenerList().get(i).getRequestInformation().getRequestMethod() + "\"" + ",");
            response.append("\"SubscriberMethod\":" + "\"" + Subscribers.getInstance().getEventListenerList().get(i).getServiceInformation().getSubscriberMethod().toString() + "\"" + ",");
            response.append("\"QueueInformation\":" + "\""
                    + Subscribers.getInstance().getEventListenerList().get(i).getChannelInformation().getQueueName() + "-"
                    + Subscribers.getInstance().getEventListenerList().get(i).getChannelInformation().getExchangeName()
                    + "\"" + ",");
            response.append("\"Path\":" + "\"" + Subscribers.getInstance().getEventListenerList().get(i).getRequestInformation().getPath() + "\"" + ",");
            response.append("\"HttpMethod\":" + "\"" + Subscribers.getInstance().getEventListenerList().get(i).getRequestInformation().getHttpMethod() + "\"" + ",");
            response.append("\"SubscriberClass\":" + "\"" + Subscribers.getInstance().getEventListenerList().get(i).getServiceInformation().getSubscriberClass().toString() + "\"");
            response.append("}");

            if (i < Subscribers.getInstance().getEventListenerList().size() - 1){
                response.append(",");
            }
        }

        response.append("]}");

        return response.toString();
    }

}
