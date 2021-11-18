package com.barvegas.backend.exception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ExceptionDetails {
    private String title;
    private int status;
    private String details;
    private String devMessage;
    private LocalDateTime timeStamp;
}
