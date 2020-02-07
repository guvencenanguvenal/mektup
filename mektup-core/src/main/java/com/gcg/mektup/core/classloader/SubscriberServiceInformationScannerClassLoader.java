package com.gcg.mektup.core.classloader;

import com.gcg.mektup.core.config.MektupConfiguration;
import com.gcg.mektup.core.exception.ConfigurationException;
import com.gcg.mektup.core.log.MektupLog;
import com.gcg.mektup.scanner.ServiceInformationScanner;
import com.gcg.mektup.scanner.SubscriberScanner;

import java.lang.reflect.InvocationTargetException;

public interface SubscriberServiceInformationScannerClassLoader {

    static ServiceInformationScanner loadClass() throws ConfigurationException {

        Class subscriberClass = null;
        Object subscriber = null;

        try {
            subscriberClass = Class.forName(MektupConfiguration.getInstance().getSubscriberServiceInformationScannerClass());
            subscriber = subscriberClass.getDeclaredConstructor().newInstance();

            MektupLog.info("ServiceInformationScanner created!");

        } catch (ClassNotFoundException e) {
            MektupLog.severe("ServiceInformationScanner is not valid!");
            throw new ConfigurationException("ServiceInformationScanner is not valid!", e);
        } catch (InstantiationException e) {
            MektupLog.severe("ServiceInformationScanner is not valid!");
            throw new ConfigurationException("ServiceInformationScanner is not valid!", e);
        } catch (IllegalAccessException e) {
            MektupLog.severe("ServiceInformationScanner is not valid!");
            throw new ConfigurationException("ServiceInformationScanner is not valid!", e);
        } catch (InvocationTargetException e) {
            MektupLog.severe("ServiceInformationScanner is not valid!");
            throw new ConfigurationException("ServiceInformationScanner is not valid!", e);
        } catch (NoSuchMethodException e) {
            MektupLog.severe("ServiceInformationScanner is not valid!");
            throw new ConfigurationException("ServiceInformationScanner is not valid!", e);
        }

        if (subscriber instanceof ServiceInformationScanner)
            return (ServiceInformationScanner) subscriber;
        else {
            MektupLog.severe("ServiceInformationScanner implementation does not implement ServiceInformationScanner!");
            throw new ConfigurationException("ServiceInformationScanner implementation does not implement ServiceInformationScanner!", new ClassCastException());
        }
    }
}
