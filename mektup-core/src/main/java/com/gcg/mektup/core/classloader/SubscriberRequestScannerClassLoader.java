package com.gcg.mektup.core.classloader;

import com.gcg.mektup.core.config.MektupConfiguration;
import com.gcg.mektup.core.exception.ConfigurationException;
import com.gcg.mektup.core.log.MektupLog;
import com.gcg.mektup.scanner.RequestInformationScanner;

import java.lang.reflect.InvocationTargetException;

public interface SubscriberRequestScannerClassLoader {

    static RequestInformationScanner loadClass() throws ConfigurationException {

        Class subscriberClass = null;
        Object subscriber = null;

        try {
            subscriberClass = Class.forName(MektupConfiguration.getInstance().getSubscriberRequestInformationScannerClass());
            subscriber = subscriberClass.getDeclaredConstructor().newInstance();

            MektupLog.info("RequestInformationScanner created!");

        } catch (ClassNotFoundException e) {
            MektupLog.severe("RequestInformationScanner is not valid!");
            throw new ConfigurationException("RequestInformationScanner is not valid!", e);
        } catch (InstantiationException e) {
            MektupLog.severe("RequestInformationScanner is not valid!");
            throw new ConfigurationException("RequestInformationScanner is not valid!", e);
        } catch (IllegalAccessException e) {
            MektupLog.severe("RequestInformationScanner is not valid!");
            throw new ConfigurationException("RequestInformationScanner is not valid!", e);
        } catch (InvocationTargetException e) {
            MektupLog.severe("RequestInformationScanner is not valid!");
            throw new ConfigurationException("RequestInformationScanner is not valid!", e);
        } catch (NoSuchMethodException e) {
            MektupLog.severe("RequestInformationScanner is not valid!");
            throw new ConfigurationException("RequestInformationScanner is not valid!", e);
        }

        if (subscriber instanceof RequestInformationScanner)
            return (RequestInformationScanner) subscriber;
        else {
            MektupLog.severe("RequestInformationScanner implementation does not implement RequestInformationScanner!");
            throw new ConfigurationException("RequestInformationScanner implementation does not implement RequestInformationScanner!", new ClassCastException());
        }
    }

}
