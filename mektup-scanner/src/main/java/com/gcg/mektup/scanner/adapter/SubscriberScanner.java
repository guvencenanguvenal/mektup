package com.gcg.mektup.scanner.adapter;

import com.gcg.mektup.scanner.exception.ScannerException;
import com.gcg.mektup.scanner.lang.EventListener;
import org.springframework.beans.factory.config.BeanDefinition;

import java.util.List;

public interface SubscriberScanner {

    List<EventListener> scanSubsciber(BeanDefinition beanDef) throws ScannerException;

}
