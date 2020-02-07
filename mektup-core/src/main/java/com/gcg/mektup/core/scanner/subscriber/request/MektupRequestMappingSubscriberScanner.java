package com.gcg.mektup.core.scanner.subscriber.request;

import com.gcg.mektup.core.annotation.definition.EventRequestMapping;
import com.gcg.mektup.scanner.RequestInformationScanner;
import com.gcg.mektup.scanner.lang.RequestInformation;

import java.lang.reflect.Method;

class MektupRequestMappingSubscriberScanner implements RequestInformationScanner {

    /**
     *
     *
     * @param subscriberMethod
     * @return RequestInformation Array
     */

    @Override
    public RequestInformation scanRequestInformationAnnotation(Method subscriberMethod) {


        EventRequestMapping eventRequestMapping  = subscriberMethod.getAnnotation(EventRequestMapping.class);
        String[] requestMappingArray = new String[eventRequestMapping.method().length];

        for (int i = 0 ; i < eventRequestMapping.method().length; i++){
            requestMappingArray[i] = eventRequestMapping.method()[i].name();
        }

        return new RequestInformation(eventRequestMapping.value(), requestMappingArray);
    }
}
