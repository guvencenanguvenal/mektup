package com.gcg.mektup.core.subscribe.method;

import com.gcg.mektup.lang.event.EventListener;

public interface Caller {

    void call(EventListener eventListener, byte[] bytes);

}
