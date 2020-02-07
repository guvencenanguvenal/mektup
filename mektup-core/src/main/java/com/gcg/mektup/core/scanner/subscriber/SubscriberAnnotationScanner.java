package com.gcg.mektup.core.scanner.subscriber;

import com.gcg.mektup.core.annotation.marker.EventSubscriberService;
import com.gcg.mektup.core.classloader.SubscriberRequestScannerClassLoader;
import com.gcg.mektup.core.classloader.SubscriberServiceInformationScannerClassLoader;
import com.gcg.mektup.core.exception.ConfigurationException;
import com.gcg.mektup.core.log.MektupLog;
import com.gcg.mektup.scanner.SubscriberScanner;
import com.gcg.mektup.scanner.exception.ScannerException;
import com.gcg.mektup.scanner.lang.ChannelInformation;
import com.gcg.mektup.scanner.lang.RequestInformation;
import com.gcg.mektup.scanner.lang.ServiceInformation;
import com.gcg.mektup.scanner.lang.SubscriberInformation;
import org.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class SubscriberAnnotationScanner implements SubscriberScanner {

    /**
     *
     * Find event subscriber services and register it all.
     *
     * @param beanDef
     */
    public List<SubscriberInformation> scanSubscriber(BeanDefinition beanDef) throws ScannerException {
        try {

            List<SubscriberInformation> subscriberInformationList = new ArrayList<>();

            Class<?> cl = Class.forName(beanDef.getBeanClassName());

            for (Method method : cl.getDeclaredMethods()) {
                if (method.isAnnotationPresent(EventSubscriberService.class)) {

                    EventSubscriberService eventSubscriberService = method.getAnnotation(EventSubscriberService.class);

                    RequestInformation requestInformation = SubscriberRequestScannerClassLoader.loadClass().scanRequestInformationAnnotation(method);
                    ServiceInformation serviceInformation = SubscriberServiceInformationScannerClassLoader.loadClass().scanServiceInformation(cl, method);

                    SubscriberInformation subscriberInformation = new SubscriberInformation(
                            eventSubscriberService.eventId()
                    );

                    subscriberInformation.setRequestInformation(requestInformation);
                    subscriberInformation.setServiceInformation(serviceInformation);

                    subscriberInformation.setChannelInformation(
                            new ChannelInformation(
                                    eventSubscriberService.exchange(),
                                    eventSubscriberService.queue())
                    );

                    subscriberInformationList.add(subscriberInformation);

                    MektupLog.info("Subscriber found : " + beanDef.getBeanClassName());
                    MektupLog.info("eventid : " + eventSubscriberService.eventId());
                    MektupLog.info("method : " + method);

                }
            }

            return subscriberInformationList;

        } catch (ClassNotFoundException e) {
            MektupLog.severe(e.getMessage());
            throw new ScannerException(e.getMessage(), e);
        } catch (ConfigurationException e) {
            MektupLog.severe(e.getMessage());
            throw new ScannerException(e.getMessage(), e);
        }

    }

}
