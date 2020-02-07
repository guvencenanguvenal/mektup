package com.gcg.mektup.scanner;

import com.gcg.mektup.scanner.exception.ScannerException;
import com.gcg.mektup.scanner.lang.SubscriberInformation;
import org.springframework.beans.factory.config.BeanDefinition;

import java.util.List;

public interface SubscriberScanner {

    List<SubscriberInformation> scanSubscriber(BeanDefinition beanDef) throws ScannerException;

}
