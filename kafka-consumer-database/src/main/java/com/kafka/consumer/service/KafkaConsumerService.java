package com.kafka.consumer.service;

import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kafka.consumer.entity.Wikimedia;
import com.kafka.consumer.repo.WikimediaRepository;

@Service
public class KafkaConsumerService {


    private final WikimediaRepository wikimediaRepository;

    public KafkaConsumerService(WikimediaRepository wikimediaRepository) {
        this.wikimediaRepository = wikimediaRepository;
    }

    @KafkaListener(topics = "wikimedia", groupId = "wikimediaGroup")
    public void consume(String message) {
        Wikimedia wikimedia = new Wikimedia();
        wikimedia.setMessage(message);
        System.out.println(message);
        wikimediaRepository.save(wikimedia);
    }
    public List<Wikimedia> getAllWikimedia() {
        List<Wikimedia> all = wikimediaRepository.findAll();
		return all;
    }
}

