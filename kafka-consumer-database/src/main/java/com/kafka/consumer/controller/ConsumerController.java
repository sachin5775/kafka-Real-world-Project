package com.kafka.consumer.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.consumer.entity.Wikimedia;
import com.kafka.consumer.service.KafkaConsumerService;

@RestController
public class ConsumerController{
	
	KafkaConsumerService kafkaConsumerService;
	public ConsumerController(KafkaConsumerService kafkaConsumerService) {
		this.kafkaConsumerService = kafkaConsumerService;
	}
	@GetMapping("/all")
	public ResponseEntity<List<Wikimedia>> getalldata() {
		List<Wikimedia> allWikimedia = kafkaConsumerService.getAllWikimedia();
		return ResponseEntity.ok(allWikimedia);

	}

}
