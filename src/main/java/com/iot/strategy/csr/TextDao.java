package com.iot.strategy.csr;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Repository
public class TextDao {

    @Value("${filepath}")
    private String filePath;

    public String getTextFromFile() throws IOException {
        Path path = Path.of(filePath);
        return Files.readString(path);
    }
}
