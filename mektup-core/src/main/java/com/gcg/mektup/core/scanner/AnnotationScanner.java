package com.gcg.mektup.core.scanner;

import com.gcg.mektup.core.scanner.subscriber.SubscriberAnnotationScanner;
import com.gcg.mektup.scanner.lang.SubscriberInformation;
import com.gcg.mektup.scanner.exception.ScannerException;
import org.springframework.beans.factory.config.BeanDefinition;

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
     * @param beanDefinition
     */
    protected List<SubscriberInformation> scan(BeanDefinition beanDefinition) throws ScannerException {

        return new SubscriberAnnotationScanner().scanSubscriber(beanDefinition);

    }





}