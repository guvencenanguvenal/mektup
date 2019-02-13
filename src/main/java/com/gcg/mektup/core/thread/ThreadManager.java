package com.gcg.mektup.core.thread;

import com.gcg.mektup.core.Mektup;
import com.gcg.mektup.logging.MektupLogger;

public class ThreadManager implements Runnable {

    final static MektupLogger logger = new MektupLogger(ThreadManager.class);

    @Override
    public void run() {

        logger.getLogger().info("ThreadManager is runnning!");

        for (int i = 0; i < Mektup.getSubscriberThreads().size(); i++){
            if (Mektup.getSubscriberThreads().get(i).isCancelled())
                logger.getLogger().warning("ThreadManager is runnning!");
        }

    }

}
