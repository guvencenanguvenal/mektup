package com.gcg.mektup.core.event;

import com.gcg.mektup.core.classloader.EventCreatorClassLoader;
import com.gcg.mektup.core.config.MektupConfiguration;
import com.gcg.mektup.core.exception.ConfigurationException;
import com.gcg.mektup.event.EventCreator;
import com.gcg.mektup.event.exception.EventCreateException;
import com.gcg.mektup.core.scanner.DependencyScanner;
import com.gcg.mektup.event.lang.EventInformation;

public interface MektupEvent {

    static void create(EventInformation eventInformation, byte[] input) throws EventCreateException, ConfigurationException {

        if (!MektupConfiguration.getInstance().isDependencyService()) {
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();

            if (stacktrace.length > 2) {
                StackTraceElement e = stacktrace[2];

                String methodName = e.getMethodName();
                String declaringClass = e.getClassName();
                String fileName = e.getFileName();

                DependencyScanner.addDependency(eventInformation.getEventId(), methodName, fileName, declaringClass);
            }
        }

        EventCreator eventCreator = EventCreatorClassLoader.loadClass();
        eventCreator.create(eventInformation, input);

    }

}
