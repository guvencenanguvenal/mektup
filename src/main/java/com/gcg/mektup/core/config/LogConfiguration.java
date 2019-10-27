package com.gcg.mektup.core.config;

import com.gcg.mektup.core.Mektup;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;

public class LogConfiguration {

    private static final LogConfiguration INSTANCE = new LogConfiguration();

    public static LogConfiguration getInstance(){
        return INSTANCE;
    }

    private LogConfiguration(){

        try (InputStream input = Mektup.class.getClassLoader().getResourceAsStream("mektup-log.properties")) {

            Properties prop = new Properties();

            prop.load(input);

            logLevel = Level.parse(prop.getProperty("mektup.log.level"));
            formatter = prop.getProperty("mektup.log.formetter");

        } catch (IOException ex) {
            System.out.println("Mektup log property is not found!");
        }

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
}
