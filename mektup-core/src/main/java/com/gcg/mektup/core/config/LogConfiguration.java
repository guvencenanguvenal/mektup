package com.gcg.mektup.core.config;

import com.gcg.mektup.core.Mektup;
import com.gcg.mektup.core.constant.ConfigConstants;
import com.gcg.mektup.core.log.MektupLog;
import com.gcg.mektup.core.exception.ConfigurationException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;

public class LogConfiguration implements Configuration, ConfigConstants {

    private static final LogConfiguration INSTANCE = new LogConfiguration();

    public static LogConfiguration getInstance(){
        return INSTANCE;
    }

    private LogConfiguration(){

    }

    private Level logLevel = Level.ALL; //Have default value
    private String formatter = "xxxx"; //Have default value

    public Level getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(Level logLevel) {
        this.logLevel = logLevel;
    }

    public String getFormatter() {
        return formatter;
    }

    public void setFormatter(String formatter) {
        this.formatter = formatter;
    }

    @Override
    public void initialize() throws ConfigurationException {
        try (InputStream input = Mektup.class.getClassLoader().getResourceAsStream(LOG_PROPERTIES_FILE_NAME)) {

            Properties prop = new Properties();
            prop.load(input);

            logLevel = Level.parse(prop.getProperty(LOG_LEVEL));
            formatter = prop.getProperty(LOG_FORMATTER);

        } catch (IOException ex) {
            MektupLog.severe("Mektup log property is not found!");
            throw new ConfigurationException("Mektup log property is not found!", ex);
        }
    }
}
