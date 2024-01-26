package com.venkataram.kafka.producer;

import static java.lang.String.format;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducer {
	
	private final KafkaTemplate<String, String> kafkaTemplate;
	
	public void sendMessage(String msg) {
		log.info(format("Sending message to quickstart-events Topic :: %s", msg));
		kafkaTemplate.send("quickstart-events", msg);
	}
	

}
