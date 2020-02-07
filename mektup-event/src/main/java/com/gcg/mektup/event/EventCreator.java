package com.gcg.mektup.event;


import com.gcg.mektup.event.exception.EventCreateException;
import com.gcg.mektup.event.lang.EventInformation;

public interface EventCreator {

    void create(EventInformation eventInformation, byte[] input) throws EventCreateException;

}
