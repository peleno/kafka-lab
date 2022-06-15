package com.iot.strategy.strategies;

import org.springframework.stereotype.Component;

@Component
public class ConsoleWriter implements Writer {
    @Override
    public void sendText(String text) {
        System.out.println(text);
    }
}
