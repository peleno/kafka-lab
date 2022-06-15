package com.iot.strategy.csr;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class TextService {
    private final TextDao dao;

    public TextService(TextDao dao) {
        this.dao = dao;
    }

    public String getTextFromFile() throws IOException {
      return dao.getTextFromFile();
    }
}
