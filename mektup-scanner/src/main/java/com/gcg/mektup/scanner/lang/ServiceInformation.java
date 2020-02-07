package com.gcg.mektup.scanner.lang;

import java.lang.reflect.Method;

public class ServiceInformation {

    //Service Information
    private  Class<?> subscriberClass;
    private  Method subscriberMethod;
    private  Class<?>[] subscriberMethodInputs;

    public ServiceInformation(){}

    public ServiceInformation(Class<?> subscriberClass, Method subscriberMethod, Class<?>[] subscriberMethodInputs){
        this.subscriberClass = subscriberClass;
        this.subscriberMethod = subscriberMethod;
        this.subscriberMethodInputs = subscriberMethodInputs;
    }

    public Class<?> getSubscriberClass() {
        return subscriberClass;
    }

    public void setSubscriberClass(Class<?> subscriberClass) {
        this.subscriberClass = subscriberClass;
    }

    public Method getSubscriberMethod() {
        return subscriberMethod;
    }

    public void setSubscriberMethod(Method subscriberMethod) {
        this.subscriberMethod = subscriberMethod;
    }

    public Class<?>[] getSubscriberMethodInputs() {
        return subscriberMethodInputs;
    }

    public void setSubscriberMethodInputs(Class<?>[] subscriberMethodInputs) {
        this.subscriberMethodInputs = subscriberMethodInputs;
    }
}
