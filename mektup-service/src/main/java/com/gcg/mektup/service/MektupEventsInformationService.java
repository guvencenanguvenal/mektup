package com.gcg.mektup.service;

import com.gcg.mektup.core.service.EventsInfoService;
import org.apache.tomcat.util.json.JSONParser;

public class MektupEventsInformationService {

    private static EventsInfoService eventsInfoService = null;

    public static String eventInfoService(){
        if (null == eventsInfoService)
            eventsInfoService = new EventsInfoService();

        return eventsInfoService.eventsInfo();
    }

}
