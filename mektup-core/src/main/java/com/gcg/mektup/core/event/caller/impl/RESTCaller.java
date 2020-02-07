package com.gcg.mektup.core.event.caller.impl;

import com.gcg.mektup.event.caller.Caller;
import com.gcg.mektup.scanner.lang.SubscriberInformation;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;

public class RESTCaller implements Caller {

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public void call(SubscriberInformation subscriberInformation, byte[] bytes) {

        String url = "http://localhost:8080";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(new String(bytes, Charset.forName("UTF-8")), headers);

        restTemplate.exchange(url + subscriberInformation.getRequestInformation().getPath(),
                HttpMethod.valueOf(subscriberInformation.getRequestInformation().getHttpMethod()),
                entity,
                String.class);


    }
}
