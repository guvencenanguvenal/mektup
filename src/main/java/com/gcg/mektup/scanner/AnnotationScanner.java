package com.gcg.mektup.scanner;

import com.gcg.mektup.annotation.marker.EventSubscriber;
import com.gcg.mektup.lang.event.EventListener;
import com.gcg.mektup.queue.core.SubscriberInformation;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author guvencenanguvenal
 *
 */
 class AnnotationScanner {

    /**
     *
     * Scanning packages to find annotations
     *
     * @param scanPackages
     */
    public void scan(String[] scanPackages) {

        List<EventListener> eventListenerList = new ArrayList<EventListener>();

        for (String scanPackage : scanPackages) {
            ClassPathScanningCandidateComponentProvider provider = createAnnotationScanner();
            for (BeanDefinition beanDef : provider.findCandidateComponents(scanPackage)) {
                eventListenerList.addAll(new SubscriberScanner().scanSubsciber(beanDef));
            }
        }

        SubscriberInformation.createInstance(eventListenerList);

    }


    /**
     * Add EventSubscriber class filter then scan method find only class which has EventSubscriber annotation
     *
     *
     * @return
     */
    private ClassPathScanningCandidateComponentProvider createAnnotationScanner() {
        // Don't pull default filters (@Component, etc.):
        ClassPathScanningCandidateComponentProvider provider
                = new ClassPathScanningCandidateComponentProvider(false);
        provider.addIncludeFilter(new AnnotationTypeFilter(EventSubscriber.class));
        return provider;
    }



}