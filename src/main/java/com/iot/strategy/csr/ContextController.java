package com.iot.strategy.csr;

import com.iot.strategy.strategies.Writer;
import com.iot.strategy.strategies.ConsoleWriter;
import com.iot.strategy.strategies.KafkaWriter;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ContextController {
    @Value("${strategy}")
    private String strategy;

    private final TextService service;
    private final BeanFactory beanFactory;

    @Autowired
    public ContextController(TextService service, BeanFactory beanFactory) {
        this.service = service;
        this.beanFactory = beanFactory;
    }

    @PostMapping("/")
    public ResponseEntity<String> sendData() throws IOException {
        String text = service.getTextFromFile();
        Writer writerObj;

        if (strategy.equals("console")) {
            writerObj = new ConsoleWriter();
            writerObj.sendText(text);
        } else if (strategy.equals("kafka")) {
            writerObj = beanFactory.getBean(KafkaWriter.class);
            writerObj.sendText(text);
        }

        return ResponseEntity.status(HttpStatus.OK).body("data using " + strategy + " strategy was successfully sent");
    }
}
