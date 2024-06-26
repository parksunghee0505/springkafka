package com.example.springkafka.simple;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class SimpleConsumer {

    private final static Logger log = LoggerFactory.getLogger(SimpleConsumer.class);

    @KafkaListener(topics = "greeting", groupId = "${spring.kafka.consumer.group-id}")
    public void receive(ConsumerRecord<String, String> record) {
        log.info("kafka receive message = {}", record);
    }

    @KafkaListener(topics = "greeting", groupId = "group2", containerFactory = "customContainerFactory")
    public void receiveCustom(ConsumerRecord<String, String> record) {
        log.info("kafka custom listener receive message = {}", record);
    }
}
