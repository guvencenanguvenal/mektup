package com.gcg.mektup.subscribe.method;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gcg.mektup.core.Mektup;
import com.gcg.mektup.lang.event.EventListener;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class InvokeSubscribe implements Caller {

    @Override
    public void call(EventListener eventListener, byte[] bytes) {

        Object obj = Mektup.getApplicationContext().getBean(eventListener.getSubscriberClass());

        if (eventListener.getSubscriberMethodInputs().length == 0){
            try {
                eventListener.getSubscriberMethod().invoke(obj);
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
                requestObj = objectMapper.readValue(bytes, eventListener.getSubscriberMethodInputs()[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                eventListener.getSubscriberMethod().invoke(obj, eventListener.getSubscriberMethodInputs()[0].cast(requestObj));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }


    }


}
