package com.venkataram.kafka.producer;

import static java.lang.String.format;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.venkataram.kafka.payload.Student;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class JsonKafkaProducer {

	private KafkaTemplate<String, Student> kafkaTemplate;
	
	@Value("${spring.kafka.topic-json.name}")
	private String jsonTopicName;
	
	public JsonKafkaProducer(KafkaTemplate<String, Student> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

	public void sendMessage(Student student) {
		log.info(format("Sending message to %s Topic :: %s", jsonTopicName, String.valueOf(student)));
		Message<Student> message = MessageBuilder
				.withPayload(student)
				.setHeader(KafkaHeaders.TOPIC, jsonTopicName)
				.build();

		kafkaTemplate.send(message);
	}

}
