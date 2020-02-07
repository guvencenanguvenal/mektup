package com.gcg.mektup.scanner;

import com.gcg.mektup.scanner.lang.RequestInformation;

import java.lang.reflect.Method;

public interface RequestInformationScanner {

    RequestInformation scanRequestInformationAnnotation(Method subscriberMethod);

}
