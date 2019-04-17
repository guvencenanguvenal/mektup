package com.gcg.mektup.scanner;

import com.gcg.mektup.annotation.definition.EventRequestMapping;
import com.gcg.mektup.annotation.marker.EventSubscriberService;
import com.gcg.mektup.lang.event.EventListener;
import com.gcg.mektup.lang.exception.ScannerException;
import com.gcg.mektup.lang.queue.QueueInformation;
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
    protected List<EventListener> scanSubsciber(BeanDefinition beanDef) throws ScannerException{
        try {

            List<EventListener> eventListenerList = new ArrayList<>();

            Class<?> cl = Class.forName(beanDef.getBeanClassName());

            for (Method method : cl.getDeclaredMethods()) {
                if (method.isAnnotationPresent(EventSubscriberService.class)
                    && method.isAnnotationPresent(EventRequestMapping.class)) {

                    EventSubscriberService eventSubscriberService = method.getAnnotation(EventSubscriberService.class);
                    EventRequestMapping eventRequestMapping  = method.getAnnotation(EventRequestMapping.class);

                    EventListener eventListener = new EventListener(
                            eventSubscriberService.eventId(),
                            cl, //Caller class
                            method, //Caller method && REST Service
                            method.getParameterTypes(), //Caller method input parameters
                            eventRequestMapping.value(), //we choose first element
                            eventRequestMapping.method() //we choose first element
                    );

                    eventListener.setQueueInformation(
                            new QueueInformation(
                                    "MEKTUP.EXCH",
                                    eventSubscriberService.queue())
                    );

                    eventListenerList.add(eventListener);

                }
            }

            return eventListenerList;

        } catch (Exception e) {
            System.err.println("Got exception: " + e.getMessage());
            throw new ScannerException(e.getMessage(), e);
        }
    }

}
