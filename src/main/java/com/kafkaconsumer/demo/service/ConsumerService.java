package com.kafkaconsumer.demo.service;

import java.io.IOException;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.stereotype.Service;

import com.kafkaconsumer.demo.model.GreetingModel;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ConsumerService {
	private static final String TOPIC = "test-topic-3";
	
	@KafkaListener(topics = TOPIC, groupId = "everis")
    public void consume(GreetingModel message) throws IOException {
        log.info(String.format("#### -> Consumed message -> %s", message));
       
        
    }
   
}
