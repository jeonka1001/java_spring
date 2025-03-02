package com.example.core.web;

import com.example.core.common.Logger;
import jakarta.inject.Provider;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class LogTryController {

    private final LogTryService logTryService;
    private final Logger logger;

    @RequestMapping("log")
    @ResponseBody
    public String logTry(HttpServletRequest request) {
        String requestURL = request.getRequestURI();
        logger.setURL(requestURL);

        logTryService.logic("test_id");
        return "OK";
    }
}
