package com.kafkaconsumer.demo.config;

import java.util.HashMap;
import java.util.Map;

import javax.sound.midi.MidiMessage;
import javax.sound.midi.Receiver;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.kafkaconsumer.demo.model.GreetingModel;

@Configuration
@EnableKafka
public class RecieverConfig {



  @Bean
  public Map<String, Object> consumerConfigs() {
    Map<String, Object> props = new HashMap<>();
    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
    props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
    props.put(ConsumerConfig.GROUP_ID_CONFIG, "everis");

    return props;
  }

  @Bean
  public ConsumerFactory<String, GreetingModel> consumerFactory() {
    return new DefaultKafkaConsumerFactory<>(consumerConfigs(), new StringDeserializer(),
        new JsonDeserializer<>(GreetingModel.class));
  }

  @Bean
  public ConcurrentKafkaListenerContainerFactory<String, GreetingModel> kafkaListenerContainerFactory() {
    ConcurrentKafkaListenerContainerFactory<String, GreetingModel> factory =
        new ConcurrentKafkaListenerContainerFactory<>();
    factory.setConsumerFactory(consumerFactory());

    return factory;
  }


}
