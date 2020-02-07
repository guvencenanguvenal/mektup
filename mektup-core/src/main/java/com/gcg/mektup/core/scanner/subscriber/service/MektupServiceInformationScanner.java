package com.gcg.mektup.core.scanner.subscriber.service;

import com.gcg.mektup.scanner.ServiceInformationScanner;
import com.gcg.mektup.scanner.lang.ServiceInformation;

import java.lang.reflect.Method;

public class MektupServiceInformationScanner implements ServiceInformationScanner {

    @Override
    public ServiceInformation scanServiceInformation(Class<?> subscriberClass, Method subscriberMethod) {
        return new ServiceInformation(subscriberClass, subscriberMethod, subscriberMethod.getParameterTypes());
    }
}
