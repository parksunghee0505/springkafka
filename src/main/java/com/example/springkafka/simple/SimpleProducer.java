package com.example.springkafka.simple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SimpleProducer {

    private final static Logger log = LoggerFactory.getLogger(SimpleProducer.class);

    private final KafkaTemplate<String, String> kafkaTemplate;

    public SimpleProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publish(String message) {
        log.info("kafka send message = {}", message);
        kafkaTemplate.send("greeting", message);
    }
}
