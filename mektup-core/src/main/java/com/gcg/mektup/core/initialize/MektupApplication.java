package com.gcg.mektup.core.initialize;

import com.gcg.mektup.core.Mektup;
import com.gcg.mektup.core.exception.MektupException;
import com.gcg.mektup.queue.exception.QueueConfigurationException;
import com.gcg.mektup.queue.exception.QueueConnectionException;
import org.springframework.context.ApplicationContext;

public class MektupApplication {

    private MektupApplication(){ }

    public static <T> void  run(Class<T> classType, ApplicationContext applicationContext) throws MektupException, QueueConnectionException, QueueConfigurationException {
        Mektup.initialize(classType, applicationContext);
    }

}
