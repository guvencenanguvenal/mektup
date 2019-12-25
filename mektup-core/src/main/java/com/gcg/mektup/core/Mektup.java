package com.gcg.mektup.core;

import com.gcg.mektup.core.config.builder.ConfigurationBuilder;
import com.gcg.mektup.core.log.MektupLog;
import com.gcg.mektup.core.service.server.MektupHttpServer;
import com.gcg.mektup.core.subscriber.Subscriber;
import com.gcg.mektup.core.annotation.scanner.MektupScan;
import com.gcg.mektup.core.exception.MektupException;
import com.gcg.mektup.core.scanner.model.SubscriberInformation;
import com.gcg.mektup.core.scanner.Scanner;
import com.gcg.mektup.queue.exception.QueueConfigurationException;
import com.gcg.mektup.queue.exception.QueueConnectionException;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Mektup {

    private static Class<?> mainClass;
    private static String[] scanPackages;

    private static ApplicationContext applicationContext;
    private static List<Future<?>> subscriberThreads = new ArrayList<Future<?>>();

    public  static <T> void  initialize(Class<T> classType, ApplicationContext applicationContext) throws MektupException, QueueConnectionException, QueueConfigurationException {

        Mektup.mainClass = classType;

        if (Mektup.mainClass.isAnnotationPresent(MektupScan.class)){

            System.out.println("___  ___     _    _               \n" +
                    "|  \\/  |    | |  | |              \n" +
                    "| .  . | ___| | _| |_ _   _ _ __  \n" +
                    "| |\\/| |/ _ \\ |/ / __| | | | '_ \\ \n" +
                    "| |  | |  __/   <| |_| |_| | |_) |\n" +
                    "\\_|  |_/\\___|_|\\_\\\\__|\\__,_| .__/ \n" +
                    "                           | |    \n" +
                    "                           |_|    \n");
            System.out.println(":: Mektup ::            (v0.0.1)");

            MektupScan scanAnnotation = Mektup.mainClass.getAnnotation(MektupScan.class);
            //TODO : Assert null
            Mektup.scanPackages = scanAnnotation.value();
            Mektup.applicationContext = applicationContext;

            ConfigurationBuilder.configInitializer();

            new Scanner().scan(Mektup.scanPackages);

            for (int i = 0; i < SubscriberInformation.getInstance().getEventListenerList().size(); i++){
                MektupLog.info("Registered Subscribing Method! : " + SubscriberInformation.getInstance().getEventListenerList().get(i).getSubscriberMethod());
                new Subscriber().subscribe(i);
            }

            MektupHttpServer mektupHttpServer = new MektupHttpServer();
            mektupHttpServer.start();

            MektupLog.info("Mektup is initialized.");

        }

    }

    public static ApplicationContext getApplicationContext(){ return Mektup.applicationContext; }

    public static List<Future<?>> getSubscriberThreads(){ return Mektup.subscriberThreads; }

}