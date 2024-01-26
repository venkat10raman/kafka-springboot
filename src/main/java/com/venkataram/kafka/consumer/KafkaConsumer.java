package com.venkataram.kafka.consumer;

import static java.lang.String.format;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaConsumer {
	
	@Value("${spring.kafka.topic.name}")
	private String stringTopic;
	
	@KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
	public void consumeMessage(String msg) {
		log.info(format("Consuming message from %s Topic :: %s", stringTopic,  msg));
	}

}
