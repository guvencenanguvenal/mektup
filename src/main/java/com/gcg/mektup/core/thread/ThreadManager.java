package com.gcg.mektup.core.thread;

import com.gcg.mektup.core.Mektup;

import java.util.logging.Logger;

public class ThreadManager implements Runnable {

    final static Logger logger = Logger.getLogger(ThreadManager.class.getName());

    @Override
    public void run() {

        logger.info("ThreadManager is runnning!");

        for (int i = 0; i < Mektup.getSubscriberThreads().size(); i++){
            if (Mektup.getSubscriberThreads().get(i).isCancelled())
                logger.warning("ThreadManager is runnning!");
        }

    }

}
