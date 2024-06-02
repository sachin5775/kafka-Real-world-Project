package com.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kafka.producer.service.WikimediaChangesProducer;

@SpringBootApplication
public class SpringBootProducerApplication implements CommandLineRunner {
	@Autowired
	private WikimediaChangesProducer wikimediaChangesProducer;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProducerApplication.class);
	}

	@Override
	public void run(String... args) throws Exception {
		wikimediaChangesProducer.start();
	}

}
