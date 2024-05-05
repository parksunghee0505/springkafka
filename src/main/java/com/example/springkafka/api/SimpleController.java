package com.example.springkafka.api;

import com.example.springkafka.simple.SimpleProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

    private final SimpleProducer producer;

    public SimpleController(SimpleProducer producer) {
        this.producer = producer;
    }

    @PostMapping("/greet")
    public String greet(String message) {
        producer.publish(message);
        return message;
    }
}
