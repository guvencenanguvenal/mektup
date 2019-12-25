package com.gcg.mektup.core.service.server;

import com.gcg.mektup.core.config.MektupConfiguration;
import com.gcg.mektup.core.log.MektupLog;
import com.gcg.mektup.core.service.DependencyService;
import com.gcg.mektup.core.service.EventsInfoService;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.*;
import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;

public class MektupHttpServer {

    private  HttpServer hs = null;

    public void start() {

        DependencyService dependencyService = new DependencyService();
        EventsInfoService eventsInfoService = new EventsInfoService();

        try {
            hs = HttpServer.create(new InetSocketAddress(MektupConfiguration.getInstance().getServicePort()), 0);

            if (MektupConfiguration.getInstance().isDependencyService()){
                hs.createContext("/mektup/dependencies", new HttpHandler() {

                    public void handle(HttpExchange t) throws IOException {
                        String response = dependencyService.eventDependencies();
                        t.getResponseHeaders().add("Content-Type", "application/json");
                        t.sendResponseHeaders(200, response.length());
                        OutputStream os = t.getResponseBody();
                        os.write(response.getBytes());
                        os.close();
                    }
                });
                MektupLog.info("Mektup dependencies services initialized. http://localhost:8888/mektup/dependencies");
            }
            if (MektupConfiguration.getInstance().isEventsInfoService()){
                hs.createContext("/mektup/eventsinfo", new HttpHandler() {

                    public void handle(HttpExchange t) throws IOException {
                        String response = eventsInfoService.eventsInfo();
                        t.getResponseHeaders().add("Content-Type", "application/json");
                        t.sendResponseHeaders(200, response.length());
                        OutputStream os = t.getResponseBody();
                        os.write(response.getBytes());
                        os.close();
                    }
                });
                MektupLog.info("Mektup dependencies services initialized. http://localhost:8888/mektup/eventsinfo");
            }


            hs.setExecutor(null);
            hs.start();

            MektupLog.info("Mektup services initialized.");

        } catch (IOException e) {
            MektupLog.severe("Mektup services initialized.");
        }
    }

    public void stop(){
        ((ExecutorService) hs.getExecutor()).shutdown();
        hs.stop(0);
    }

}
