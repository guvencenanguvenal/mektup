package com.gcg.mektup.core.config;

import com.gcg.mektup.core.Mektup;
import com.gcg.mektup.core.constant.ConfigConstants;
import com.gcg.mektup.core.log.MektupLog;
import com.gcg.mektup.core.exception.ConfigurationException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ChannelConfiguration implements Configuration, ConfigConstants {

    private static final ChannelConfiguration INSTANCE = new ChannelConfiguration();

    public static ChannelConfiguration getInstance(){ return INSTANCE; }

    private ChannelConfiguration(){

    }

    private String queueAdapter = "";

    public String getQueueAdapter() {
        return queueAdapter;
    }

    @Override
    public void initialize() throws ConfigurationException {
        try (InputStream input = Mektup.class.getClassLoader().getResourceAsStream(MEKTUP_PROPERTIES_FILE_NAME)) {

            Properties prop = new Properties();
            prop.load(input);

            queueAdapter = prop.getProperty(QUEUE_ADAPTER);

        } catch (IOException ex) {
            MektupLog.severe("Mektup log property is not found!");
            throw new ConfigurationException("Mektup log property is not found!", ex);
        }
    }
}
