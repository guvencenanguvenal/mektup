package com.gcg.mektup.core.scanner;

import com.gcg.mektup.core.log.MektupLog;
import com.gcg.mektup.core.annotation.definition.EventRequestMapping;
import com.gcg.mektup.core.annotation.marker.EventSubscriberService;
import com.gcg.mektup.scanner.adapter.SubscriberScanner;
import com.gcg.mektup.scanner.lang.EventListener;
import com.gcg.mektup.scanner.exception.ScannerException;
import com.gcg.mektup.scanner.lang.QueueInformation;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

 class SpringBootRequestMappingSubscriberScanner implements SubscriberScanner {

    /**
     *
     * Find event subscriber services and register it all.
     *
     * @param beanDef
     */
    public List<EventListener> scanSubsciber(BeanDefinition beanDef) throws ScannerException{
        try {

            List<EventListener> eventListenerList = new ArrayList<>();

            Class<?> cl = Class.forName(beanDef.getBeanClassName());

            for (Method method : cl.getDeclaredMethods()) {
                if (method.isAnnotationPresent(EventSubscriberService.class)
                    && method.isAnnotationPresent(RequestMapping.class)) {

                    EventSubscriberService eventSubscriberService = method.getAnnotation(EventSubscriberService.class);
                    RequestMapping eventRequestMapping  = method.getAnnotation(RequestMapping.class);

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

                    MektupLog.info("Subscriber found : " + beanDef.getBeanClassName());
                    MektupLog.info("eventid : " + eventSubscriberService.eventId());
                    MektupLog.info("method : " + method);

                }
            }

            return eventListenerList;

        } catch (ClassNotFoundException e) {
            MektupLog.severe(e.getMessage());
            throw new ScannerException(e.getMessage(), e);
        }
    }

}
