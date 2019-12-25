package com.gcg.mektup.core.subscriber.method;

import com.gcg.mektup.core.subscriber.Caller;
import com.gcg.mektup.core.event.lang.EventListener;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;

public class RESTSubscribe implements Caller {

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public void call(EventListener eventListener, byte[] bytes) {

        String url = "http://localhost:8080";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(new String(bytes, Charset.forName("UTF-8")), headers);

        restTemplate.exchange(url + eventListener.getPath(),
                eventListener.getHttpMethod(),
                entity,
                String.class);


    }
}
