package com.gcg.mektup.scanner;

import com.gcg.mektup.scanner.lang.ServiceInformation;

import java.lang.reflect.Method;

public interface ServiceInformationScanner {

    ServiceInformation scanServiceInformation(Class<?> subscriberClass, Method subscriberMethod);

}
