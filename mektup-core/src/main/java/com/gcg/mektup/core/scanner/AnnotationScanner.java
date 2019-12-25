package com.gcg.mektup.core.scanner;

import com.gcg.mektup.core.annotation.marker.EventSubscriber;
import com.gcg.mektup.core.log.MektupLog;
import com.gcg.mektup.core.event.lang.EventListener;
import com.gcg.mektup.core.exception.ScannerException;
import com.gcg.mektup.core.scanner.model.SubscriberInformation;
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
    protected void scan(String[] scanPackages) throws ScannerException {

        List<EventListener> eventListenerList = new ArrayList<>();

        for (String scanPackage : scanPackages) {
            ClassPathScanningCandidateComponentProvider provider = createAnnotationScanner();
            MektupLog.info("Scanning package : " + scanPackage);
            for (BeanDefinition beanDef : provider.findCandidateComponents(scanPackage)) {
                eventListenerList.addAll(new SubscriberScanner().scanSubsciber(beanDef));
            }
        }

        SubscriberInformation.createInstance(eventListenerList);

    }

    /**
     * Add EventExecuter class filter then scan method find only class which has EventExecuter annotation
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