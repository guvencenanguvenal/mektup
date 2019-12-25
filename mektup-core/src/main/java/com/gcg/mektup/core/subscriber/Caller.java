package com.gcg.mektup.core.subscriber;

import com.gcg.mektup.core.event.lang.EventListener;

public interface Caller {

    void call(EventListener eventListener, byte[] bytes);

}
