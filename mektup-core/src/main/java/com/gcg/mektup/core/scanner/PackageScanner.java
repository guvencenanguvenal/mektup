package com.gcg.mektup.core.scanner;

import com.gcg.mektup.core.annotation.marker.EventSubscriber;
import com.gcg.mektup.core.log.MektupLog;
import com.gcg.mektup.core.subscriber.lang.Subscribers;
import com.gcg.mektup.scanner.exception.ScannerException;
import com.gcg.mektup.scanner.lang.SubscriberInformation;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.util.ArrayList;
import java.util.List;

public class PackageScanner {

    /**
     *
     * Scanning packages to find annotations
     *
     * @param scanPackages
     */
    public void scan(String[] scanPackages) throws ScannerException {

        List<SubscriberInformation> subscriberInformationList = new ArrayList<>();

        for (String scanPackage : scanPackages) {
            ClassPathScanningCandidateComponentProvider provider = createAnnotationScanner();
            MektupLog.info("Scanning package : " + scanPackage);
            for (BeanDefinition beanDef : provider.findCandidateComponents(scanPackage)) {
                subscriberInformationList.addAll(new AnnotationScanner().scan(beanDef));
            }
        }

        Subscribers.createInstance(subscriberInformationList);

    }

    /**
     * Add EventExecuter class filter then scan method find only class which has EventExecuter annotation
     *
     *
     * @return
     */
    private ClassPathScanningCandidateComponentProvider createAnnotationScanner() {

        ClassPathScanningCandidateComponentProvider provider
                = new ClassPathScanningCandidateComponentProvider(false);
        provider.addIncludeFilter(new AnnotationTypeFilter(EventSubscriber.class));
        return provider;
    }

}
