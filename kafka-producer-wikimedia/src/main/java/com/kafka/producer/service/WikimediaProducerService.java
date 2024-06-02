package com.kafka.producer.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.kafka.producer.config.KafkaTopicConfig;

@Service
public class WikimediaProducerService {
	KafkaTemplate<String, String> kafkaTemplate;

	public WikimediaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendmessage(String message) {
		kafkaTemplate.send(KafkaTopicConfig.WIKIMEDIA, message);
		//System.out.println("Message sent on Topic -->"+ message);
		
	}
}
