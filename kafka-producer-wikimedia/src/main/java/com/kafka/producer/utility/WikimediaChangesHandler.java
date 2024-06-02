package com.kafka.producer.utility;

import com.kafka.producer.service.WikimediaProducerService;
import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;

public class WikimediaChangesHandler implements EventHandler {

    private final WikimediaProducerService wikimediaProducerService;

    public WikimediaChangesHandler(WikimediaProducerService wikimediaProducerService) {
        this.wikimediaProducerService = wikimediaProducerService;
    }

    @Override
    public void onOpen() {
        // No action needed on open
    }

    @Override
    public void onClosed() {
        // No action needed on close
    }

    @Override
    public void onMessage(String event, MessageEvent messageEvent) {
    	wikimediaProducerService.sendmessage(messageEvent.getData());
    }

    @Override
    public void onComment(String comment) {
        // No action needed on comment
    }

    @Override
    public void onError(Throwable t) {
        t.printStackTrace();
    }
}
