package com.gcg.mektup.core.server.http.services;

import com.gcg.mektup.core.scanner.model.SubscriberInformation;

public class EventsInfoService {

    private EventsInfoService(){} //We dont create instance

    public static String eventsInfo(){

        StringBuilder response = new StringBuilder();

        response.append("{ \"Event Info\" : [");

        for (int i = 0; i < SubscriberInformation.getInstance().getEventListenerList().size(); i++){
            response.append("{");
            response.append("\"Id\":" + SubscriberInformation.getInstance().getEventListenerList().get(i).getEventId() + ",");
            response.append("\"RequestMethod\":" + "\"" + SubscriberInformation.getInstance().getEventListenerList().get(i).getRequestMethod().toString() + "\"" + ",");
            response.append("\"SubscriberMethod\":" + "\"" + SubscriberInformation.getInstance().getEventListenerList().get(i).getSubscriberMethod().toString() + "\"" + ",");
            response.append("\"QueueInformation\":" + "\""
                    + SubscriberInformation.getInstance().getEventListenerList().get(i).getQueueInformation().getQueueName() + "-"
                    + SubscriberInformation.getInstance().getEventListenerList().get(i).getQueueInformation().getExchangeName()
                    + "\"" + ",");
            response.append("\"Path\":" + "\"" + SubscriberInformation.getInstance().getEventListenerList().get(i).getPath() + "\"" + ",");
            response.append("\"HttpMethod\":" + "\"" + SubscriberInformation.getInstance().getEventListenerList().get(i).getHttpMethod().toString() + "\"" + ",");
            response.append("\"SubscriberClass\":" + "\"" + SubscriberInformation.getInstance().getEventListenerList().get(i).getSubscriberClass().toString() + "\"");
            response.append("}");

            if (i < SubscriberInformation.getInstance().getEventListenerList().size() - 1){
                response.append(",");
            }
        }

        response.append("]}");

        return response.toString();
    }

}
