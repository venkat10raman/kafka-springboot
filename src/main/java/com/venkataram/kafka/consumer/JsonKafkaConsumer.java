package com.venkataram.kafka.consumer;

import static java.lang.String.format;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.venkataram.kafka.payload.Student;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class JsonKafkaConsumer {
	
	@KafkaListener(topics = "${spring.kafka.topic-json.name}", groupId = "${spring.kafka.consumer.group-id}")
	public void consumeJsonMessage(Student student) {
		log.info(format("Consuming message from quickstart-events Topic :: %s", String.valueOf(student)));
	}

}
