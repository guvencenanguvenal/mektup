package com.gcg.mektup.core.log;

import com.gcg.mektup.core.config.LogConfiguration;
import com.gcg.mektup.core.Mektup;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MektupLog {

    final static Logger logger = Logger.getLogger(Mektup.class.getName());

    private MektupLog(){ }

    private static void log(Level level, String log){
        if (LogConfiguration.getInstance().getLogLevel().intValue() >= level.intValue())
            logger.log(level, log);
    }

    public static void severe(String log){
        MektupLog.log(Level.SEVERE, log);
    }

    public static void warn(String log){
        MektupLog.log(Level.WARNING, log);
    }

    public static void info(String log){
        MektupLog.log(Level.INFO, log);
    }

    public static void config(String log){
        MektupLog.log(Level.CONFIG, log);
    }

}
