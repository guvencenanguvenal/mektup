package com.gcg.mektup.core.event;

import com.gcg.mektup.core.config.MektupConfiguration;
import com.gcg.mektup.core.publisher.EventPublisher;
import com.gcg.mektup.core.scanner.DependencyScanner;
import com.gcg.mektup.core.exception.EventCreateException;
import com.gcg.mektup.queue.exception.QueueConfigurationException;
import com.gcg.mektup.queue.exception.QueueConnectionException;

public class EventCreator {

    public EventCreator(){ }

    public void create(Long eventId, byte[] input) throws EventCreateException {

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
        try {
            creator.publish(eventId, input);
        } catch (QueueConnectionException e) {
            throw new EventCreateException(e.getMessage(), e);
        } catch (QueueConfigurationException e) {
            throw new EventCreateException(e.getMessage(), e);
        }
    }

}
