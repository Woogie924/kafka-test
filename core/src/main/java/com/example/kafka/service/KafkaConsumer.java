package com.example.kafka.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class KafkaConsumer {

    private static final String TOPIC = "new-topic";

    @KafkaListener(topics = TOPIC)
    public void consume(String message) {
        System.out.println(String.format("Consumed message : %s", message));
    }

}
