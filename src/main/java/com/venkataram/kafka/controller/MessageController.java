package com.venkataram.kafka.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.venkataram.kafka.payload.Student;
import com.venkataram.kafka.producer.JsonKafkaProducer;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/messages")
@RequiredArgsConstructor
public class MessageController {
	
	private final JsonKafkaProducer jsonKafkaProducer;
	
	@PostMapping
	public ResponseEntity<String> sendJsonMessage(@RequestBody Student student){
		jsonKafkaProducer.sendMessage(student);
		return ResponseEntity.ok("Json Message queued successfully");
	}

}
