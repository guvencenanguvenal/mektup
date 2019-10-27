package com.gcg.mektup.event;

import com.gcg.mektup.core.publish.EventPublisher;
import com.gcg.mektup.core.scanner.DependencyScanner;
import com.gcg.mektup.lang.exception.EventCreateException;

public class EventCreator {

    private EventCreator(){ }

    public static void create(Long eventId, byte[] input) throws EventCreateException {

        StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
        StackTraceElement e = stacktrace[2];//maybe this number needs to be corrected
        String methodName = e.getMethodName();
        String declaringClass = e.getClassName();
        String fileName = e.getFileName();

        DependencyScanner.addDependency(eventId, methodName, fileName, declaringClass);

        EventPublisher creator = new EventPublisher();
        creator.publish(eventId, input);
    }

}
