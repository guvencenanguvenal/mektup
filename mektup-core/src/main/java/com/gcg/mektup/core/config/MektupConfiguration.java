package com.gcg.mektup.core.config;

import com.gcg.mektup.core.Mektup;
import com.gcg.mektup.core.constant.ConfigConstants;
import com.gcg.mektup.core.log.MektupLog;
import com.gcg.mektup.core.exception.ConfigurationException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MektupConfiguration implements Configuration, ConfigConstants {

    private static final MektupConfiguration INSTANCE = new MektupConfiguration();

    public static MektupConfiguration getInstance(){
        return INSTANCE;
    }

    private MektupConfiguration(){

    }

    private boolean dependencyService = true; //Have default value
    private boolean eventsInfoService = true; //Have default value
    private int servicePort = 8888; //Have default value

    private String subscriberServiceInformationScannerClass = "com.gcg.mektup.core.scanner.subscriber.service.MektupServiceInformationScanner"; //Have default value
    private String subscriberRequestInformationScannerClass = "com.gcg.mektup.core.scanner.subscriber.request.MektupRequestMappingSubscriberScanner"; //Have default value
    private String subscriberScannerClass = "com.gcg.mektup.core.scanner.subscriber.SubscriberAnnotationScanner"; //Have default value
    private String eventCreatorClass = "com.gcg.mektup.core.event.impl.CoreEventCreator"; //Have default value

    private String callerClass = "com.gcg.mektup.core.event.caller.impl.InvokeSubscribe"; //Have default value

    public boolean isDependencyService() {
        return dependencyService;
    }

    public boolean isEventsInfoService() {
        return eventsInfoService;
    }

    public int getServicePort() {
        return servicePort;
    }

    public String getSubscriberScannerClass() {
        return subscriberScannerClass;
    }

    public void setSubscriberScannerClass(String subscriberScannerClass) {
        this.subscriberScannerClass = subscriberScannerClass;
    }

    public String getEventCreatorClass() {
        return eventCreatorClass;
    }

    public void setEventCreatorClass(String eventCreatorClass) {
        this.eventCreatorClass = eventCreatorClass;
    }

    @Override
    public void initialize() throws ConfigurationException {
        try (InputStream input = Mektup.class.getClassLoader().getResourceAsStream(ConfigConstants.MEKTUP_PROPERTIES_FILE_NAME)) {

            Properties prop = new Properties();
            prop.load(input);

            dependencyService = Boolean.valueOf(prop.getProperty(DEPENDENCY_SERVICE));
            eventsInfoService = Boolean.valueOf(prop.getProperty(EVENTS_INFO_SERVICE));
            servicePort = Integer.valueOf(prop.getProperty(MEKTUP_SERVICE_PORT));

            subscriberServiceInformationScannerClass = prop.getProperty(SUBSCRIBER_SERVICE_INFORMATION_SCANNER_CLASS);
            subscriberRequestInformationScannerClass = prop.getProperty(SUBSCRIBER_REQUEST_INFORMATION_SCANNER_CLASS);
            subscriberScannerClass = prop.getProperty(SUBSCRIBER_SCANNER_CLASS);
            eventCreatorClass = prop.getProperty(EVENT_CREATOR_CLASS);

            callerClass = prop.getProperty(EVENT_CREATOR_CLASS);

        } catch (IOException ex) {
            MektupLog.severe("Mektup property is not found!");
            throw new ConfigurationException("Mektup property is not found!", ex);
        }
    }

    public String getSubscriberRequestInformationScannerClass() {
        return subscriberRequestInformationScannerClass;
    }

    public void setSubscriberRequestInformationScannerClass(String subscriberRequestInformationScannerClass) {
        this.subscriberRequestInformationScannerClass = subscriberRequestInformationScannerClass;
    }

    public String getSubscriberServiceInformationScannerClass() {
        return subscriberServiceInformationScannerClass;
    }

    public void setSubscriberServiceInformationScannerClass(String subscriberServiceInformationScannerClass) {
        this.subscriberServiceInformationScannerClass = subscriberServiceInformationScannerClass;
    }

    public String getCallerClass() {
        return callerClass;
    }

    public void setCallerClass(String callerClass) {
        this.callerClass = callerClass;
    }
}
