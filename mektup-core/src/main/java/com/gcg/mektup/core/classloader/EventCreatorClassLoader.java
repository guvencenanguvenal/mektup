package com.gcg.mektup.core.classloader;

import com.gcg.mektup.core.config.MektupConfiguration;
import com.gcg.mektup.core.exception.ConfigurationException;
import com.gcg.mektup.core.log.MektupLog;
import com.gcg.mektup.event.EventCreator;

import java.lang.reflect.InvocationTargetException;

public interface EventCreatorClassLoader {

    static EventCreator loadClass() throws ConfigurationException {

        Class eventCreatorClass = null;
        Object eventCreator = null;

        try {
            eventCreatorClass = Class.forName(MektupConfiguration.getInstance().getEventCreatorClass());
            eventCreator = eventCreatorClass.getDeclaredConstructor().newInstance();

            MektupLog.info("EventCreator created!");

        } catch (ClassNotFoundException e) {
            MektupLog.severe("EventCreator is not valid!");
            throw new ConfigurationException("EventCreator is not valid!", e);
        } catch (InstantiationException e) {
            MektupLog.severe("EventCreator is not valid!");
            throw new ConfigurationException("EventCreator is not valid!", e);
        } catch (IllegalAccessException e) {
            MektupLog.severe("EventCreator is not valid!");
            throw new ConfigurationException("EventCreator is not valid!", e);
        } catch (InvocationTargetException e) {
            MektupLog.severe("QueueAdapter is not valid!");
            throw new ConfigurationException("EventCreator is not valid!", e);
        } catch (NoSuchMethodException e) {
            MektupLog.severe("EventCreator is not valid!");
            throw new ConfigurationException("EventCreator is not valid!", e);
        }

        if (eventCreator instanceof EventCreator)
            return (EventCreator) eventCreator;
        else {
            MektupLog.severe("Queue implementation does not implement EventCreator!");
            throw new ConfigurationException("Event Creator implementation does not implement EventCreator!", new ClassCastException());
        }
    }

}
