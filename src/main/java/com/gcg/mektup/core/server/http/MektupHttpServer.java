package com.gcg.mektup.core.server.http;

import com.gcg.mektup.core.config.MektupConfiguration;
import com.gcg.mektup.core.log.MektupLog;
import com.gcg.mektup.core.server.http.services.DependencyService;
import com.gcg.mektup.core.server.http.services.EventsInfoService;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.*;
import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;

public class MektupHttpServer {

    private  HttpServer hs = null;

    public void start() {

        try {
            hs = HttpServer.create(new InetSocketAddress(8888), 0);

            if (MektupConfiguration.getInstance().isDependencyService()){
                hs.createContext("/mektup/dependencies", new HttpHandler() {

                    public void handle(HttpExchange t) throws IOException {
                        InputStream is = t.getRequestBody();
                        System.out.println(t.getRemoteAddress().toString());
                        String response = DependencyService.eventDependencies();
                        t.sendResponseHeaders(200, response.length());
                        t.getResponseHeaders().add("Content-Type", "application/json");
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
                        InputStream is = t.getRequestBody();
                        String response = EventsInfoService.eventsInfo();
                        t.sendResponseHeaders(200, response.length());
                        t.getResponseHeaders().add("Content-Type", "application/json");
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
