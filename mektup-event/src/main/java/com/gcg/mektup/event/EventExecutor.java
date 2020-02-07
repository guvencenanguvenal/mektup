package com.gcg.mektup.event;

import com.gcg.mektup.scanner.lang.SubscriberInformation;

public interface EventExecutor {

    void execute(SubscriberInformation subscriberInformation, byte[] output);

}
