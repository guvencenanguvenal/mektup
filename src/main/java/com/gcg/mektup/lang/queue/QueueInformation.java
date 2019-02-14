package com.gcg.mektup.lang.queue;

public class QueueInformation {

    //Queue Informations
    private String exchangeName;
    private String queueName;

    public QueueInformation(String exchangeName, String queueName){
        this.exchangeName = exchangeName;
        this.queueName = queueName;
    }

    public String getExchangeName() {
        return exchangeName;
    }

    public void setExchangeName(String exchangeName) {
        this.exchangeName = exchangeName;
    }

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }
}
