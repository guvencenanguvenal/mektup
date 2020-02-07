package com.gcg.mektup.core.channel;

import com.gcg.mektup.core.classloader.ChannelClassLoader;
import com.gcg.mektup.core.exception.ConfigurationException;
import com.gcg.mektup.channel.ChannelAdapter;

public class ChannelFactory {

    private ChannelFactory(){}

    private static ChannelAdapter CHANNEL_INSTANCE = null;

    public static ChannelAdapter getChannel() throws ConfigurationException {

        if (null == ChannelFactory.CHANNEL_INSTANCE)
            return ChannelFactory.CHANNEL_INSTANCE = ChannelClassLoader.loadClass();
        else
            return ChannelFactory.CHANNEL_INSTANCE;

    }

}
