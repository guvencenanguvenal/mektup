package com.gcg.mektup.lang.exception;


import java.util.logging.Level;
import java.util.logging.Logger;

public class MektupException extends Exception {

    final static Logger logger = Logger.getLogger(MektupException.class.getName());

    protected MektupException(String errorMessage) {
        super(errorMessage);
        logger.log(Level.SEVERE, "Exception occur : \n" + errorMessage);
    }

    protected MektupException(String errorMessage, Throwable err){
        super(errorMessage, err);
        logger.log(Level.SEVERE, "Exception occur : \n" + errorMessage, err);
    }


}
