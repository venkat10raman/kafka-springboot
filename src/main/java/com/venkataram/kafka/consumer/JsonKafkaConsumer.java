package com.venkataram.kafka.consumer;

import static java.lang.String.format;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.venkataram.kafka.payload.Student;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class JsonKafkaConsumer {
	
	@Value("${spring.kafka.topic-json.name}")
	private String jsonTopicName;
	
	@KafkaListener(topics = "${spring.kafka.topic-json.name}", groupId = "${spring.kafka.consumer.group-id}")
	public void consumeJsonMessage(Student student) {
		log.info(format("Consuming message from %s Topic :: %s", jsonTopicName, String.valueOf(student)));
	}

}
