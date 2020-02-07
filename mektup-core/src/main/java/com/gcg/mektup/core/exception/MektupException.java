package com.gcg.mektup.core.exception;


import java.util.logging.Level;
import java.util.logging.Logger;

public class MektupException extends Exception {

    final static Logger logger = Logger.getLogger(MektupException.class.getName());

    public MektupException(String errorMessage) {
        super(errorMessage);
        logger.log(Level.SEVERE, "Exception occur : \n" + errorMessage);
    }

    public MektupException(String errorMessage, Throwable err){
        super(errorMessage, err);
        logger.log(Level.SEVERE, "Exception occur : \n" + errorMessage, err);
    }


}
