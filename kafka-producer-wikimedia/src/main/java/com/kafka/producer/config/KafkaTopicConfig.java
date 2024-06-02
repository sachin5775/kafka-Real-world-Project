package com.kafka.producer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
	public static final String WIKIMEDIA = "wikimedia";

	@Bean
	public NewTopic wikimedia() {
		NewTopic wikimedia = TopicBuilder.name(WIKIMEDIA).build();
		return wikimedia;

	}
}
