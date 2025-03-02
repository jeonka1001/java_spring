package com.example.core.common;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
public class LogFormat {
    private String uuid;
    private String requestURL;
    private String message;
}
