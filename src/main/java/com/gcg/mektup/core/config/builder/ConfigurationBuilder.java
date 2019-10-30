package com.gcg.mektup.core.config.builder;

import com.gcg.mektup.core.config.LogConfiguration;
import com.gcg.mektup.core.config.MektupConfiguration;
import com.gcg.mektup.core.config.QueueConfiguration;
import com.gcg.mektup.lang.exception.ConfigurationException;

public class ConfigurationBuilder {

    private ConfigurationBuilder(){}

    public static void configInitializer() throws ConfigurationException {
        LogConfiguration.getInstance().initialize();
        MektupConfiguration.getInstance().initialize();
        QueueConfiguration.getInstance().initialize();
    }

}
