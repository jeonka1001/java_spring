package com.example.core.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@NoArgsConstructor
@Getter @Setter
public class Logger {
    private LogFormat logFormat;

    public void log(String message) {
        this.logFormat.setMessage(message);
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = "null";
        try {
            jsonString = objectMapper.writeValueAsString(this.logFormat);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(jsonString);
    }

    public void setURL(String url) {
        this.logFormat.setRequestURL(url);
    }

    @PostConstruct
    public void init() {
        this.logFormat = new LogFormat();
        this.logFormat.setUuid(UUID.randomUUID().toString());
        this.log("requests scope bean create");
    }

    @PreDestroy
    public void close() {
        this.log("requests scope bean close");
    }
}
