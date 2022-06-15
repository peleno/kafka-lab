package com.iot.strategy.strategies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SendTextToKafka implements SendText {

    @Value("${kafka.topic_name}")
    private String kafkaTopicName;

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public SendTextToKafka(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendText(String text) {
        String[] messages = text.split("\r\n");
        for (int i = 0; i < messages.length; i++) {
            kafkaTemplate.send(kafkaTopicName, messages[i]);
        }
    }
}
