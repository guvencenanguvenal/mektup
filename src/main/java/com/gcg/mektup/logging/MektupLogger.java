package com.gcg.mektup.logging;

import java.util.logging.Logger;

public class MektupLogger {

    private final Logger logger;

    public MektupLogger(Class<?> logClass){
        logger = Logger.getLogger(logClass.getName());
    }

    public Logger getLogger(){ return this.logger; }

}
