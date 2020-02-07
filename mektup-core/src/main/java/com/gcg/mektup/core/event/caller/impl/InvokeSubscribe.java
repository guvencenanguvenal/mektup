package com.gcg.mektup.core.event.caller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gcg.mektup.core.Mektup;
import com.gcg.mektup.event.caller.Caller;
import com.gcg.mektup.scanner.lang.SubscriberInformation;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class InvokeSubscribe implements Caller {

    @Override
    public void call(SubscriberInformation subscriberInformation, byte[] bytes) {

        Object obj = Mektup.getApplicationContext().getBean(subscriberInformation.getServiceInformation().getSubscriberClass());

        if (subscriberInformation.getServiceInformation().getSubscriberMethodInputs().length == 0){
            try {
                subscriberInformation.getServiceInformation().getSubscriberMethod().invoke(obj);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        else{
            //TODO : this is not String this must be object
            //TODO : inputtypes annotation control
            ObjectMapper objectMapper = new ObjectMapper();
            Object requestObj = null;
            try {
                requestObj = objectMapper.readValue(bytes, subscriberInformation.getServiceInformation().getSubscriberMethodInputs()[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                subscriberInformation.getServiceInformation().getSubscriberMethod().invoke(obj, subscriberInformation.getServiceInformation().getSubscriberMethodInputs()[0].cast(requestObj));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }


    }


}
