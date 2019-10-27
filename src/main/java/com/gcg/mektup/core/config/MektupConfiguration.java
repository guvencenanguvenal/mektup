package com.gcg.mektup.core.config;

import com.gcg.mektup.core.Mektup;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MektupConfiguration {

    private static final MektupConfiguration INSTANCE = new MektupConfiguration();

    public static MektupConfiguration getInstance(){
        return INSTANCE;
    }

    private MektupConfiguration(){
        try (InputStream input = Mektup.class.getClassLoader().getResourceAsStream("mektup.properties")) {

            Properties prop = new Properties();

            prop.load(input);

            dependencyService = Boolean.valueOf(prop.getProperty("mektup.service.dependencyService"));
            eventsInfoService = Boolean.valueOf(prop.getProperty("mektup.service.eventsInfoService"));


        } catch (IOException ex) {
            System.out.println("Mektup log property is not found!");
        }
    }

    private boolean dependencyService = true; //Have default value
    private boolean eventsInfoService = true; //Have default value


    public boolean isDependencyService() {
        return dependencyService;
    }

    public boolean isEventsInfoService() {
        return eventsInfoService;
    }
}
