package com.venkataram.kafka.producer;

import static java.lang.String.format;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducer {
	
	private final KafkaTemplate<String, String> kafkaTemplate;
	
	@Value("${spring.kafka.topic.name}")
	private String stringTopic;
	
	public void sendMessage(String msg) {
		log.info(format("Sending message to %s Topic :: %s", stringTopic, msg));
		kafkaTemplate.send(stringTopic, msg);
	}
	

}
