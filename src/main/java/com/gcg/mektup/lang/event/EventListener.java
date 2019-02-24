package com.gcg.mektup.lang.event;

import com.gcg.mektup.lang.queue.QueueInformation;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.reflect.Method;

public class EventListener {

    //EventListener Informations
    private Long eventId;

    //Queue Informations
    private QueueInformation queueInformation;

    //Service Information
    private final Class<?> subscriberClass;
    private final Method subscriberMethod;
    private final Class<?>[] subscriberMethodInputs;


    private final String[] path;
    private final RequestMethod[] requestMethod;

    public EventListener(Class<?> subscriberClass,
                         Method subscriberMethod,
                         Class<?>[] subscriberMethodInputs,
                         String[] path,
                         RequestMethod[] requestMethod) {
        this.subscriberClass = subscriberClass;
        this.subscriberMethod = subscriberMethod;
        this.subscriberMethodInputs = subscriberMethodInputs;
        this.path = path;
        this.requestMethod = requestMethod;
    }


    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Class<?> getSubscriberClass() {
        return subscriberClass;
    }

    public Method getSubscriberMethod() {
        return subscriberMethod;
    }

    public QueueInformation getQueueInformation() {
        return queueInformation;
    }

    public void setQueueInformation(QueueInformation queueInformation) {
        this.queueInformation = queueInformation;
    }

    public String getPath() {
        return path[0] == null ? "" : path[0];
    }

    public RequestMethod getRequestMethod() {
        if (requestMethod.length != 0)
            return requestMethod[0];

        return RequestMethod.POST;
    }

    public HttpMethod getHttpMethod(){
        return HttpMethod.values()[this.getRequestMethod().ordinal()];
    }

    public Class<?>[] getSubscriberMethodInputs() {
        return subscriberMethodInputs;
    }
}
