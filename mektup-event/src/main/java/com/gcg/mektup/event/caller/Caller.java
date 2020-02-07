package com.gcg.mektup.event.caller;

import com.gcg.mektup.scanner.lang.SubscriberInformation;

public interface Caller {

    void call(SubscriberInformation subscriberInformation, byte[] bytes);

}
