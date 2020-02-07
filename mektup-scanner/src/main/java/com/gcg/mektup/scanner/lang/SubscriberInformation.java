package com.gcg.mektup.scanner.lang;

public class SubscriberInformation {

    //EventListener Informations
    private final Long eventId;

    //Queue Informations
    private ChannelInformation channelInformation;

    private ServiceInformation serviceInformation;
    private RequestInformation requestInformation;

    public SubscriberInformation(
                        Long eventId) {
        this.eventId = eventId;
    }


    public Long getEventId() {
        return eventId;
    }

    public ChannelInformation getChannelInformation() {
        return channelInformation;
    }

    public void setChannelInformation(ChannelInformation channelInformation) {
        this.channelInformation = channelInformation;
    }

    public RequestInformation getRequestInformation() {
        return requestInformation;
    }

    public void setRequestInformation(RequestInformation requestInformation) {
        this.requestInformation = requestInformation;
    }

    public ServiceInformation getServiceInformation() {
        return serviceInformation;
    }

    public void setServiceInformation(ServiceInformation serviceInformation) {
        this.serviceInformation = serviceInformation;
    }
}
