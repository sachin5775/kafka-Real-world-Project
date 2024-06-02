package com.kafka.producer.service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import com.kafka.producer.utility.WikimediaChangesHandler;
import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;

@Service
public class WikimediaChangesProducer {

    private final WikimediaProducerService wikimediaProducerService;

    public WikimediaChangesProducer(WikimediaProducerService wikimediaProducerService) {
        this.wikimediaProducerService = wikimediaProducerService;
    }

    public void start() {
        EventHandler eventHandler = new WikimediaChangesHandler(wikimediaProducerService);
        String url = "https://stream.wikimedia.org/v2/stream/recentchange";
        EventSource.Builder builder = new EventSource.Builder(eventHandler, URI.create(url));
        EventSource eventSource = builder.build();
        eventSource.start();
        
        // Run for a certain period to demonstrate functionality
        try {
            TimeUnit.MINUTES.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        eventSource.close();
    }
}

