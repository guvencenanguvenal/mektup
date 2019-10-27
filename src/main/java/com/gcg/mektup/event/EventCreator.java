package com.gcg.mektup.event;

import com.gcg.mektup.core.config.MektupConfiguration;
import com.gcg.mektup.core.publish.EventPublisher;
import com.gcg.mektup.core.scanner.DependencyScanner;
import com.gcg.mektup.lang.exception.EventCreateException;

public class EventCreator {

    private EventCreator(){ }

    public static void create(Long eventId, byte[] input) throws EventCreateException {

        if (!MektupConfiguration.getInstance().isDependencyService()) {
            StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();

            if (stacktrace.length > 2) {
                StackTraceElement e = stacktrace[2];

                String methodName = e.getMethodName();
                String declaringClass = e.getClassName();
                String fileName = e.getFileName();

                DependencyScanner.addDependency(eventId, methodName, fileName, declaringClass);
            }
        }

        EventPublisher creator = new EventPublisher();
        creator.publish(eventId, input);
    }

}
