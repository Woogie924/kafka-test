package com.example.web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

@Service
@RequiredArgsConstructor
public class KafkaProducer {
    private static final String TOPIC = "new-topic";
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String topic, String payload) {
        System.out.println(String.format("topic =  %s, payload = %s", topic, payload));
        ListenableFuture<SendResult<String, String>> listenable = kafkaTemplate.send(TOPIC, payload);
    }
}

