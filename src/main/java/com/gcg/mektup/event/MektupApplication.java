package com.gcg.mektup.event;

import com.gcg.mektup.core.Mektup;
import com.gcg.mektup.lang.exception.MektupException;
import org.springframework.context.ApplicationContext;

public class MektupApplication {

    private MektupApplication(){ }

    public static <T> void  run(Class<T> classType, ApplicationContext applicationContext) throws MektupException {
        Mektup.initialize(classType, applicationContext);
    }

}
