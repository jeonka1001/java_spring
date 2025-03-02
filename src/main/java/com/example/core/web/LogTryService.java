package com.example.core.web;


import com.example.core.common.Logger;
import jakarta.inject.Provider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogTryService {
    private final Logger logger;

    public void logic(String id) {
        logger.log("servie id = " + id);
    }
}
