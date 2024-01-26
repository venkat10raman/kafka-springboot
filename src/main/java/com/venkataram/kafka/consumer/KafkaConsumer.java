package com.venkataram.kafka.consumer;

import static java.lang.String.format;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaConsumer {
	
	@KafkaListener(topics = "quickstart-events", groupId = "myGroup")
	public void consumeMessage(String msg) {
		log.info(format("Consuming message from quickstart-events Topic :: %s", msg));
	}

}
