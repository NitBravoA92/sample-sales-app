package com.softwaredevone.sample_sales_app.exceptions;

import java.time.LocalDateTime;

public record ErrorResponse(String message, int status, LocalDateTime timestamp) {
    public ErrorResponse(String message, int status) {
        this(message, status, LocalDateTime.now());
    }
}