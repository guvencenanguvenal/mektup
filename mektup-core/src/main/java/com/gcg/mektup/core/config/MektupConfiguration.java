package com.gcg.mektup.core.config;

import com.gcg.mektup.core.Mektup;
import com.gcg.mektup.core.constant.ConfigConstants;
import com.gcg.mektup.core.log.MektupLog;
import com.gcg.mektup.core.exception.ConfigurationException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MektupConfiguration implements Configuration {

    private static final MektupConfiguration INSTANCE = new MektupConfiguration();

    public static MektupConfiguration getInstance(){
        return INSTANCE;
    }

    private MektupConfiguration(){

    }

    private boolean dependencyService = true; //Have default value
    private boolean eventsInfoService = true; //Have default value
    private int servicePort = 8888; //Have default value

    public boolean isDependencyService() {
        return dependencyService;
    }

    public boolean isEventsInfoService() {
        return eventsInfoService;
    }

    public int getServicePort() {
        return servicePort;
    }

    @Override
    public void initialize() throws ConfigurationException {
        try (InputStream input = Mektup.class.getClassLoader().getResourceAsStream(ConfigConstants.MEKTUP_PROPERTIES_FILE_NAME)) {

            Properties prop = new Properties();
            prop.load(input);

            dependencyService = Boolean.valueOf(prop.getProperty(ConfigConstants.DEPENDENCY_SERVICE));
            eventsInfoService = Boolean.valueOf(prop.getProperty(ConfigConstants.EVENTS_INFO_SERVICE));
            servicePort = Integer.valueOf(prop.getProperty(ConfigConstants.MEKTUP_SERVICE_PORT));

        } catch (IOException ex) {
            MektupLog.severe("Mektup property is not found!");
            throw new ConfigurationException("Mektup property is not found!", ex);
        }
    }
}
