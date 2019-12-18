package com.gcg.mektup.core.config;

import com.gcg.mektup.core.Mektup;
import com.gcg.mektup.core.constant.ConfigConstants;
import com.gcg.mektup.lang.exception.ConfigurationException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class QueueConfiguration implements Configuration {

    private static final QueueConfiguration INSTANCE = new QueueConfiguration();

    public static QueueConfiguration getInstance(){ return INSTANCE; }

    private QueueConfiguration(){

    }

    private String queueAdapter = "";

    public String getQueueAdapter() {
        return queueAdapter;
    }

    @Override
    public void initialize() throws ConfigurationException {
        try (InputStream input = Mektup.class.getClassLoader().getResourceAsStream(ConfigConstants.MEKTUP_PROPERTIES_FILE_NAME)) {

            Properties prop = new Properties();

            prop.load(input);

            queueAdapter = prop.getProperty(ConfigConstants.QUEUE_ADAPTER);

        } catch (IOException ex) {
            System.out.println("Mektup log property is not found!");
            throw new ConfigurationException("Mektup log property is not found!", ex);
        }
    }
}
