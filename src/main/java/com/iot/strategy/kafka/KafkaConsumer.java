package com.iot.strategy.kafka;

import com.iot.strategy.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
    private static final Logger logger =
            LoggerFactory.getLogger(Application.class);

    @KafkaListener(topics = "${kafka.topic_name}", groupId = "${kafka.group_id}")
    public void listener(String message) {
        logger.info("Received message = {}", message);
    }
}
