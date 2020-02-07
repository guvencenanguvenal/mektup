package com.gcg.mektup.core.classloader;

import com.gcg.mektup.core.config.MektupConfiguration;
import com.gcg.mektup.core.exception.ConfigurationException;
import com.gcg.mektup.core.log.MektupLog;
import com.gcg.mektup.event.caller.Caller;

import java.lang.reflect.InvocationTargetException;

public interface EventServiceCallerClassLoader {

    static Caller loadClass() throws ConfigurationException {

        Class callerClass = null;
        Object callerObject = null;

        try {
            callerClass = Class.forName(MektupConfiguration.getInstance().getCallerClass());
            callerObject = callerClass.getDeclaredConstructor().newInstance();

            MektupLog.info("Caller created!");

        } catch (ClassNotFoundException e) {
            MektupLog.severe("Caller is not valid!");
            throw new ConfigurationException("Caller is not valid!", e);
        } catch (InstantiationException e) {
            MektupLog.severe("Caller is not valid!");
            throw new ConfigurationException("Caller is not valid!", e);
        } catch (IllegalAccessException e) {
            MektupLog.severe("Caller is not valid!");
            throw new ConfigurationException("Caller is not valid!", e);
        } catch (InvocationTargetException e) {
            MektupLog.severe("Caller is not valid!");
            throw new ConfigurationException("Caller is not valid!", e);
        } catch (NoSuchMethodException e) {
            MektupLog.severe("Caller is not valid!");
            throw new ConfigurationException("Caller is not valid!", e);
        }

        if (callerObject instanceof Caller)
            return (Caller) callerObject;
        else {
            MektupLog.severe("Queue implementation does not implement Caller!");
            throw new ConfigurationException("Queue implementation does not implement Caller!", new ClassCastException());
        }
    }

}
