package com.gcg.mektup.core.config.builder;


import com.gcg.mektup.core.config.LogConfiguration;
import com.gcg.mektup.core.config.MektupConfiguration;
import com.gcg.mektup.core.config.ChannelConfiguration;
import com.gcg.mektup.core.log.MektupLog;
import com.gcg.mektup.core.exception.ConfigurationException;

public class ConfigurationBuilder {

    private ConfigurationBuilder(){}

    public static void configInitializer() throws ConfigurationException {
        LogConfiguration.getInstance().initialize();
        MektupConfiguration.getInstance().initialize();
        ChannelConfiguration.getInstance().initialize();

        MektupLog.info("Mektup property initialized.");
    }

}
