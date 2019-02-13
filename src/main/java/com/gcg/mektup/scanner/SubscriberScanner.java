package com.gcg.mektup.scanner;

import com.gcg.mektup.annotation.marker.EventSubscriberService;
import com.gcg.mektup.lang.event.EventListener;
import org.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

 class SubscriberScanner {

    /**
     *
     * Find event subscriber services and register it all.
     *
     * @param beanDef
     */
    public List<EventListener> scanSubsciber(BeanDefinition beanDef) {
        try {

            List<EventListener> eventListenerList = new ArrayList<EventListener>();

            Class<?> cl = Class.forName(beanDef.getBeanClassName());

            for (Method method : cl.getDeclaredMethods()) {
                if (method.isAnnotationPresent(EventSubscriberService.class)) {
                    //TODO find subscriber method

                    EventListener eventListener = new EventListener(
                            cl, //Subscriber class
                            method, //Subscriber method && REST Service
                            method.getParameterTypes() //Method inputs
                    );
                    eventListenerList.add(eventListener);

                    //Object obj = Mektup.getApplicationContext().getBean(cl);
                    //method.invoke(obj);

                }
            }

            return eventListenerList;

        } catch (Exception e) {
            System.err.println("Got exception: " + e.getMessage());

            return null;
        }
    }

}
